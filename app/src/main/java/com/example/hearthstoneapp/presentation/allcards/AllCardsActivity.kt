package com.example.hearthstoneapp.presentation.allcards

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.databinding.ActivityAllCardsBinding
import com.example.hearthstoneapp.presentation.allcards.basic.adapter.BasicAdapter
import com.example.hearthstoneapp.presentation.allcards.classic.adapter.ClassicAdapter
import com.example.hearthstoneapp.presentation.allcards.halloffame.adapter.HallOfFameAdapter
import com.example.hearthstoneapp.presentation.di.Injector
import javax.inject.Inject

class AllCardsActivity:
    AppCompatActivity(),
    OnAllCardsBasicRecyclerViewClickListener,
    OnAllCardsClassicRecyclerViewClickListener,
    OnAllCardsHallOfFameRecyclerViewClickListener
{
    @Inject
    lateinit var factory: AllCardsViewModelFactory
    private lateinit var allCardsViewModel: AllCardsViewModel
    private val allCardsClassicList = ArrayList<AllCardsClassic>()
    private val allCardsBasicList = ArrayList<AllCardsBasic>()
    private val allCardsHallOfFameList = ArrayList<AllCardsHallOfFame>()
    private var basicAdapter: BasicAdapter = BasicAdapter(allCardsBasicList, this)
    private var classicAdapter: ClassicAdapter = ClassicAdapter(allCardsClassicList, this)
    private var hallOfFameAdapter: HallOfFameAdapter = HallOfFameAdapter(allCardsHallOfFameList, this)
    private lateinit var binding: ActivityAllCardsBinding
    private val concatAdapter = ConcatAdapter(basicAdapter, classicAdapter, hallOfFameAdapter)
    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation
    private lateinit var rotateForward: Animation
    private lateinit var rotateBackward: Animation
    private var isOpen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_cards)
        (application as Injector).createAllCardsBasicSubComponent()
            .inject(this)

        allCardsViewModel = ViewModelProvider(this,factory)
            .get(AllCardsViewModel::class.java)


        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        initRecyclerView()
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward)
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward)
        binding.fab.setOnClickListener {
            animateFab()
        }
        binding.fab1.setOnClickListener {
            animateFab()
        }
        binding.fab2.setOnClickListener {
            animateFab()
        }
    }

    private fun animateFab() {
        if(isOpen) {
            binding.fab.startAnimation(rotateForward)
            binding.fab1.startAnimation(fabClose)
            binding.fab2.startAnimation(fabClose)
            binding.fab1.isClickable = false
            binding.fab2.isClickable = false
            isOpen = false
        } else {
            binding.fab.startAnimation(rotateBackward)
            binding.fab1.startAnimation(fabOpen)
            binding.fab2.startAnimation(fabOpen)
            binding.fab1.isClickable = true
            binding.fab2.isClickable = true
            isOpen = true
        }
    }

    private fun initRecyclerView(){
        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.allCardsRecyclerView.adapter = concatAdapter
        displayAllCards()
    }

    private fun displayAllCards(){
        binding.allCardsProgressBar.visibility = View.VISIBLE
        val responseLiveDataBasic = allCardsViewModel.getAllCardsBasic()
        val responseLiveDataClassic = allCardsViewModel.getAllCardsClassic()
        val responseLiveDataHallOfFame = allCardsViewModel.getAllCardsHallOfFame()
        responseLiveDataBasic.observe(this, Observer {
            if(it!=null){
                basicAdapter.setList(it)
                basicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
        responseLiveDataClassic.observe(this, Observer {
            if(it!=null){
                classicAdapter.setList(it)
                classicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
        responseLiveDataHallOfFame.observe(this, Observer {
            if(it!=null){
                hallOfFameAdapter.setList(it)
                hallOfFameAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.update -> {
                initRecyclerView()
                true
            }
            R.id.basic -> {
                initRecyclerViewBasic()
                true
            }
            R.id.classic -> {
                initRecyclerViewClassic()
                true
            }
            R.id.hall_of_fame -> {
                initRecyclerViewHallOfFame()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun initRecyclerViewBasic(){
        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.allCardsRecyclerView.adapter = basicAdapter
        displayAllCardsBasic()
    }

    private fun initRecyclerViewClassic(){
        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.allCardsRecyclerView.adapter = classicAdapter
        displayAllCardsClassic()
    }

    private fun initRecyclerViewHallOfFame(){
        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.allCardsRecyclerView.adapter = hallOfFameAdapter
        displayAllCardsHallOfFame()
    }

    private fun displayAllCardsBasic() {
        binding.allCardsProgressBar.visibility = View.VISIBLE
        val responseLiveDataBasic = allCardsViewModel.getAllCardsBasic()
        responseLiveDataBasic.observe(this, Observer {
            if(it!=null){
                basicAdapter.setList(it)
                basicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun displayAllCardsClassic() {
        binding.allCardsProgressBar.visibility = View.VISIBLE
        val responseLiveDataClassic = allCardsViewModel.getAllCardsClassic()
        responseLiveDataClassic.observe(this, Observer {
            if(it!=null){
                classicAdapter.setList(it)
                classicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun displayAllCardsHallOfFame() {
        binding.allCardsProgressBar.visibility = View.VISIBLE
        val responseLiveDataHallOfFame = allCardsViewModel.getAllCardsHallOfFame()
        responseLiveDataHallOfFame.observe(this, Observer {
            if(it!=null){
                hallOfFameAdapter.setList(it)
                hallOfFameAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }


    private fun updateAllCards(){
        binding.allCardsProgressBar.visibility = View.VISIBLE
        val responseBasic = allCardsViewModel.updateAllCardsBasic()
        val responseClassic = allCardsViewModel.updateAllCardsClassic()
        val responseHallOfFame = allCardsViewModel.updateAllCardsHallOfFame()
        responseBasic.observe(this, Observer {
            if(it!=null){
                basicAdapter.setList(it)
                basicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
            }
        })
        responseClassic.observe(this, Observer {
            if(it!=null){
                classicAdapter.setList(it)
                classicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
            }
        })
        responseHallOfFame.observe(this, Observer {
            if(it!=null){
                hallOfFameAdapter.setList(it)
                hallOfFameAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
            }
        })
    }

    override fun onAllCardsBasicItemClicked(position: Int) {
        val intent = Intent(this, AllCardsBasicDetail::class.java)
        intent.putExtra("nameOfBasicCard", allCardsBasicList[position].name)
        startActivity(intent)
    }

    override fun onAllCardsClassicItemClicked(position: Int) {
        val intent = Intent(this, AllCardsClassicDetail::class.java)
        intent.putExtra("nameOfClassicCard", allCardsClassicList[position].name)
        startActivity(intent)
    }

    override fun onAllCardsHallOfFameItemClicked(position: Int) {
        val intent = Intent(this, AllCardsHallOfFameDetail::class.java)
        intent.putExtra("nameOfHallOfFameCard", allCardsHallOfFameList[position].name)
        startActivity(intent)
    }
}