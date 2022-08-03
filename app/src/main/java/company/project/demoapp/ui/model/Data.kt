package company.project.demoapp.ui.model

import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("totalItems"   ) var totalItems   : Int?            = null,
    @SerializedName("startIndex"   ) var startIndex   : Int?            = null,
    @SerializedName("itemsPerPage" ) var itemsPerPage : Int?            = null,
    @SerializedName("list"         ) var list         : ArrayList<List> = arrayListOf()
){
    data class List(

        @SerializedName("_id"      ) var Id       : String?           = null,
        @SerializedName("pictures" ) var pictures : Pictures?         = Pictures(),
        @SerializedName("price"    ) var price    : Int?              = null,
        @SerializedName("age"      ) var age      : Int?              = null,
        @SerializedName("isGraded" ) var isGraded : Boolean?          = null,
        @SerializedName("isSold"   ) var isSold   : Boolean?          = null,
        @SerializedName("isCoin"   ) var isCoin   : Boolean?          = null,
        @SerializedName("tags"     ) var tags     : ArrayList<String> = arrayListOf(),
        @SerializedName("name"     ) var name     : String?           = null,
        @SerializedName("history"  ) var history  : String?           = null,
        @SerializedName("year"     ) var year     : Int?              = null

    ){
        data class Pictures(
            @SerializedName("front" ) var front : Front? = Front(),
        ){
            data class Front(

                @SerializedName("key"            ) var key            : String? = null,
                @SerializedName("url"            ) var url            : String? = null,
                @SerializedName("sizeInMegaByte" ) var sizeInMegaByte : Double? = null

            )

        }

    }

}
