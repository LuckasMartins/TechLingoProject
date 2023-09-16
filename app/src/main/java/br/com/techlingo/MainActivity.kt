package br.com.techlingo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.techlingo.ui.theme.TechLingoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_entrar = findViewById(R.id.btnLogin) as Button
        btn_entrar.setOnClickListener{
            Toast.makeText(this, "VOCÊ ENTROU", Toast.LENGTH_SHORT).show()

            // Inicie a ListaCursosActivity após o login
            val intent = Intent(this, ListaCursosActivity::class.java)
            startActivity(intent)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TechLingoTheme {
        Greeting("Android")
    }
}