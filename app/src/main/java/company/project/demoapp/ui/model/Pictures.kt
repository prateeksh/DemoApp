package company.project.demoapp.ui.model

import com.google.gson.annotations.SerializedName

data class Pictures(
    @SerializedName("front" ) var front : Front? = Front(),
   )
