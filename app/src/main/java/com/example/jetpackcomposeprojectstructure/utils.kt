import android.content.Context
import android.content.SharedPreferences

// In your LoginViewModel or after login success
fun storeUserId(context: Context, userId: Long) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    sharedPreferences.edit().putLong("user_id", userId).apply()
}

