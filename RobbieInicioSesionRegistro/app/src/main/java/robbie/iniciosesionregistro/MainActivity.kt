package robbie.iniciosesionregistro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //1- Mandar a llamar a todos los elementos de la pantalla
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtContra = findViewById<EditText>(R.id.txtContra)
        val btnRegistar = findViewById<Button>(R.id.btnIngresar)

        //Programar el boton
        btnRegistar.setOnClickListener {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(txtCorreo.text.toString(),txtContra.text.toString())
        }

    }
}