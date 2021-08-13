package com.udacity.shoestore

import android.app.Application
import android.text.Editable
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel():ViewModel() {

    private val shoeList__= mutableListOf<Shoe>(
            Shoe("Black Running Shoes",40.0,"Bahati Co.","Comfortable running shoes", "https://images.unsplash.com/photo-1491553895911-0055eca6402d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=800&q=80"),
        Shoe("Blue White Orange Running Shoes",40.0,"Jasso Inc.","Comfortable running shoes", "https://images.unsplash.com/photo-1588099768531-a72d4a198538?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
        Shoe("Pastel Colored Running Shoes",40.0,"Larin Co.","Comfortable running shoes", "https://images.unsplash.com/photo-1595950653106-6c9ebd614d3a?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
        Shoe("Cream Boots",40.0,"Quezada Co.","Leather Boots", "https://images.unsplash.com/photo-1610398752800-146f269dfcc8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
        Shoe("Black Heels",30.0,"Najla Cam Co.","Elegant Heels", "https://images.unsplash.com/photo-1596702876489-9d11e5806161?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=675&q=80"),
        Shoe("Black Shoe",44.0,"Ameli Inc.","Comfortable running shoes", "https://images.unsplash.com/photo-1621881538090-b2b5ffaa996a?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80"),
        Shoe("Pink High Heels",40.0,"Allanwood Co.","Flashy Heels", "https://images.unsplash.com/photo-1581101767113-1677fc2beaa8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80"),
        Shoe("Black Boots",40.0,"Mahmoudi Co.","Leather Boots", "https://images.unsplash.com/photo-1605732440685-d0654d81aa30?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"),
        Shoe("Grey Running Shoes",40.0,"Kachanovsky Co.","Comfortable running shoes", "https://images.unsplash.com/photo-1550399865-ec7d23b18e8e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=640&q=80"),
        Shoe("White High Heels",40.0,"Borba Inc.","Elegant Heels", "https://images.unsplash.com/photo-1562687848-c1664eff566d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=634&q=80"))
    private var shoeList_ = MutableLiveData<List<Shoe>>(shoeList__)
    val shoeList:LiveData<List<Shoe>> get()=shoeList_
    var shoe_name = MutableLiveData<String>("")
    var shoe_size = MutableLiveData<Double>()
    var shoe_comp = MutableLiveData<String>("")
    var shoe_desc = MutableLiveData<String>("")
    var shoe_url = MutableLiveData<String>("")
    private var navigate_to_list_ = MutableLiveData<Boolean>()
    val navigate_to_list:LiveData<Boolean> get()=navigate_to_list_
    private var is_login_ = false


    fun logingIn(){
        is_login_ = true
    }
    fun is_login():Boolean{
        return is_login_
    }

    fun onNavigated(){
        navigate_to_list_.value = false
        shoe_name.value =""
        shoe_size
                .postValue(null)
        shoe_comp.value=""
        shoe_desc.value=""
        shoe_url.value=""
    }
    fun clear(){
        shoe_name.value =""
        shoe_size
                .postValue(null)
        shoe_comp.value=""
        shoe_desc.value=""
        shoe_url.value=""
    }
    fun addNewShoeNew(i:Int?){
        if(i==1) {
            if (shoe_url.value == "") { shoe_url.value = "https://image.flaticon.com/icons/png/512/2043/2043907.png" }
            shoeList__.add(Shoe(shoe_name.value + "", shoe_size.value?.toDouble(), shoe_comp.value, shoe_desc.value, shoe_url.value))
        }
        navigate_to_list_.value = true
    }
}