package com.example.hearthstoneapp.presentation.allcards

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_cards)
        (application as Injector).createAllCardsBasicSubComponent()
            .inject(this)

        allCardsViewModel = ViewModelProvider(this,factory)
            .get(AllCardsViewModel::class.java)


        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        initRecyclerView()
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
            R.id.action_update -> {
                updateAllCards()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

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