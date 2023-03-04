package users.profile.kotlinapi.Model

class Shows() {
   lateinit  var  listShow:ArrayList<Show>

    init {
        listShow= ArrayList<Show>()
    }
   fun ajouter(show: Show){
       listShow.add(show)
   }
   @JvmName("getListShow1")
   fun getListShow():ArrayList<Show>{
       return  listShow
   }

    override fun toString(): String {
        var msg=""
        for (i in listShow){
            msg+="\n"+i.toString()
        }
        return msg
    }
}