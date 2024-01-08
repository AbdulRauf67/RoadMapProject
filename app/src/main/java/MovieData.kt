import android.health.connect.datatypes.units.Length
import android.os.Parcel
import android.os.Parcelable

public final data class MovieData(
    val sr_no:Int=0,
    val name: String="",
    val generic:String="",
    val year:String="",
    val length:String="",
    val director:String="",
    val decp:String="",
    val Url:String=""):Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(sr_no)
        parcel.writeString(name)
        parcel.writeString(generic)
        parcel.writeString(year)
        parcel.writeString(length)
        parcel.writeString(director)
        parcel.writeString(decp)
        parcel.writeString(Url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieData> {
        override fun createFromParcel(parcel: Parcel): MovieData {
            return MovieData(parcel)
        }

        override fun newArray(size: Int): Array<MovieData?> {
            return arrayOfNulls(size)
        }
    }


}