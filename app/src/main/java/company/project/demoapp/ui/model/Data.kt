package company.project.demoapp.ui.model

import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("totalItems"   ) var totalItems   : Int?            = null,
    @SerializedName("startIndex"   ) var startIndex   : Int?            = null,
    @SerializedName("itemsPerPage" ) var itemsPerPage : Int?            = null,
    @SerializedName("list"         ) var list         : ArrayList<List> = arrayListOf()
)
