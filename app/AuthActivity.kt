import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    // 1. Declaramos la herramienta de Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        auth = FirebaseAuth.getInstance()

        // 2. Lógica simple: Si ya inició sesión antes, entra directo
        val currentUser = auth.currentUser
        if (currentUser != null) {
            goToHome()
        }
    }

    // 3. Función para registrar nuevos usuarios
    private fun registerUser(email: String, pass: String) {
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "¡Bienvenido a QuickEarn!", Toast.LENGTH_SHORT).show()
                    goToHome()
                } else {
                    Toast.makeText(baseContext, "Error al registrarse.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun goToHome() {
        // Aquí pondremos el código para saltar a la pantalla de tareas
    }
}
