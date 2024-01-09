package com.example.roadmapproject

import java.io.Serializable

class MyCustomObject: Serializable {
    var name=" "
    var id=0
    var place=""
    constructor(mName: String,mId:Int,mPlace:String){
        name=mName
        id=mId
        place=mPlace
    }
    constructor()
}