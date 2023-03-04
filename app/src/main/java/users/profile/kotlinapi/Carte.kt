package users.profile.kotlinapi
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import users.profile.kotlinapi.Model.Shows

class Carte(private val context:Context,private val shows:Shows):BaseAdapter() {
    private lateinit var img:ImageView
    private lateinit var name:TextView
    private lateinit var genre:TextView
    private lateinit var rating:TextView
    private lateinit var country:TextView
    private lateinit var summary:TextView
    override fun getCount(): Int {
        return shows.getListShow().size
    }

    override fun getItem(position: Int): Any {
      return position
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView=convertView
        convertView=LayoutInflater.from(context).inflate(R.layout.r_activity,parent,false)
        img=convertView.findViewById(R.id.img)
        name=convertView.findViewById(R.id.name)
        genre=convertView.findViewById(R.id.genre)
        rating=convertView.findViewById(R.id.rating)
        country=convertView.findViewById(R.id.country)
        summary=convertView.findViewById(R.id.summary)
        var s=shows.getListShow().get(position)
        Picasso.get().load(s.img).into(img)
        name.text=s.name
        genre.text=s.genre
        rating.text=s.rating
        country.text=s.contry
        summary.text=s.summary
        return convertView

    }

}
