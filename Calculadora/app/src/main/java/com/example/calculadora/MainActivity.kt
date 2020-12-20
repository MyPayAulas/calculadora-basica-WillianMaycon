package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        numero_zero.setOnClickListener { AcrescentrarUmaExpressao ("0", true) }
        numero_um.setOnClickListener { AcrescentrarUmaExpressao ("1", true) }
        numero_dois.setOnClickListener { AcrescentrarUmaExpressao ("2", true) }
        numero_tres.setOnClickListener { AcrescentrarUmaExpressao ("3", true) }
        numero_quatro.setOnClickListener { AcrescentrarUmaExpressao ("4", true) }
        numero_cinco.setOnClickListener { AcrescentrarUmaExpressao ("5", true) }
        numero_seis.setOnClickListener { AcrescentrarUmaExpressao ("6", true) }
        numero_sete.setOnClickListener { AcrescentrarUmaExpressao ("7", true) }
        numero_oito.setOnClickListener { AcrescentrarUmaExpressao ("8", true) }
        numero_nove.setOnClickListener { AcrescentrarUmaExpressao ("9", true) }
        ponto.setOnClickListener { AcrescentrarUmaExpressao (".", true) }


        soma.setOnClickListener { AcrescentrarUmaExpressao( "+", false) }
        subtracao.setOnClickListener { AcrescentrarUmaExpressao( "-", false) }
        multiplicacao.setOnClickListener { AcrescentrarUmaExpressao( "*", false) }
        divisao.setOnClickListener { AcrescentrarUmaExpressao( "/", false) }

        limpar.setOnClickListener {
            expressao.text = ""
            txt_resultado.text = ""
        }
        remove.setOnClickListener {

            val string = expressao.text.toString()

            if (string.isNotBlank()) {
                expressao.text = string.substring(0,string.length-1)
            }
            txt_resultado.text = ""
        }
        igual.setOnClickListener {

            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()

                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if(resultado == longResult.toDouble())
                    txt_resultado.text = longResult.toString()
                    else
                    txt_resultado.text = resultado.toString()


            }catch (e: Exception) {

            }
        }


    }

    fun AcrescentrarUmaExpressao(string: String, limpar_dados : Boolean){

        if (txt_resultado.text.isNotEmpty()){
            expressao.text = ""
        }
        if (limpar_dados){
            txt_resultado.text = ""
            expressao.append(string)
        }else{
            expressao.append(txt_resultado.text)
            expressao.append(string)
            txt_resultado.text =""
        }

    }
}