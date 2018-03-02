package com.example.logonrm.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonrm.myapplication.extencion.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        if (intent != null){
            val peso = intent.getStringExtra("PESO").toDouble()
            val altura = intent.getStringExtra("ALTURA").toDouble()

            val imc = peso / (altura * altura)

            tvValorIMC.setText(imc.format(1))

            if (imc <= 18.5) {
                alteraImagem(R.drawable.abaixo)
                tvStatusIMC.text = "Abaixo do Peso"
            }else if(imc <= 24.9){
                alteraImagem(R.drawable.ideal)
                tvStatusIMC.text = "Peso Ideal"
            }else if(imc <= 29.9){
                alteraImagem(R.drawable.sobre)
                tvStatusIMC.text = "Acima do Peso"
            }else if(imc <= 39.9){
                alteraImagem(R.drawable.obesidade)
                tvStatusIMC.text = "Obesidade I"
            }else if(imc <= 49.9){
                alteraImagem(R.drawable.obesidade)
                tvStatusIMC.text = "Obesidade II (Mevera)"
            }else{
                alteraImagem(R.drawable.obesidade)
                tvStatusIMC.text = "Obesidade II (Mórbida)"
            }
        }
    }

    fun alteraImagem(idImagem: Int) {
        ivStatusIMC.setImageDrawable(ContextCompat.getDrawable(this, idImagem))
    }
}
