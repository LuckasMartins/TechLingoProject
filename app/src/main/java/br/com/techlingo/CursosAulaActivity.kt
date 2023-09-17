package br.com.techlingo

import ApiService
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CursosAulaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curso_aula);

        // Defina a URL base do seu servidor
        // 10.0.2.2 é o localhost dentro do emulador android
        // Também deve ser adicionado AndroidManifest.xml -> <uses-permission android:name="android.permission.INTERNET" />
        // Também é necessário criar a classe ApiService.kt
        // para que o Retrofit possa fazer a solicitação HTTP
        // pelos metodos criados na interface

        // obtenha a 'api_baseurl' do arquivo 'strings.xml'
        val baseUrl = getString(R.string.api_baseurl)

        // Crie uma instância Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)


        val sharedPreferences = getSharedPreferences(getString(R.string.preferencias), MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "email") ?: "Não obtido"
        val senha = sharedPreferences.getString("senha", "senha") ?: "Não obtido"
        val nm_curso = sharedPreferences.getString("nm_curso", "nm_curso") ?: "Não obtido"
        val dt_entrada = sharedPreferences.getString("curso_dt_entrada", "dt_entrada") ?: "Não obtido"
        val st_status = sharedPreferences.getString("curso_st_status", "st_status") ?: "Não obtido"
        val curso_aulas = sharedPreferences.getString("curso_aulas", "curso_aulas") ?: "Não obtido"

        val ds_titulo = sharedPreferences.getString("aula_ds_titulo", "ds_titulo") ?: "Não obtido"
        val ds_link_video = sharedPreferences.getString("aula_ds_link_video", "ds_link_video") ?: "Não obtido"
        val ds_descricao_quiz = sharedPreferences.getString("aula_ds_descricao_quiz", "ds_descricao_quiz") ?: "Não obtido"
        val ds_pergunta1 = sharedPreferences.getString("aula_ds_pergunta1", "ds_pergunta1") ?: "Não obtido"
        val ds_pergunta2 = sharedPreferences.getString("aula_ds_pergunta2", "ds_pergunta2") ?: "Não obtido"
        val ds_pergunta3 = sharedPreferences.getString("aula_ds_pergunta3", "ds_pergunta3") ?: "Não obtido"
        val ds_resposta = sharedPreferences.getString("aula_ds_resposta", "ds_resposta") ?: "Não obtido"


        val txt_nm_curso = findViewById(R.id.txt_nome_curso) as TextView
        val txt_aula_titulo = findViewById(R.id.txt_aula_titulo) as TextView
        val txt_descricao_quiz = findViewById(R.id.txt_quiz_descricao) as TextView
        val radioGroup = findViewById(R.id.radioGroup) as RadioGroup
        val radio_pergunta1 = findViewById(R.id.btn_quiz_1) as RadioButton
        val radio_pergunta2 = findViewById(R.id.btn_quiz_2) as RadioButton
        val radio_pergunta3 = findViewById(R.id.btn_quiz_3) as RadioButton


        txt_nm_curso.text = nm_curso
        txt_aula_titulo.text = ds_titulo
        txt_descricao_quiz.text = ds_descricao_quiz

        radio_pergunta1.text = ds_pergunta1
        radio_pergunta2.text = ds_pergunta2
        radio_pergunta3.text = ds_pergunta3
        radioGroup.setOnCheckedChangeListener{ group, checkedId ->

            val radio: RadioButton = findViewById(checkedId)
            if (radio.text == ds_resposta) {
                radio.setTextColor(Color.GREEN)
            }
            else {
                radio.setTextColor(Color.RED)
            }
        }

        val imagem = findViewById(R.id.aula_imagem) as ImageView
        imagem.setOnClickListener{
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ds_link_video))
                startActivity(intent)
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }



    }


}


