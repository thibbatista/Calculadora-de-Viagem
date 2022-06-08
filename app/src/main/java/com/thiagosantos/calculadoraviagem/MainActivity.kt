package com.thiagosantos.calculadoraviagem

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate =  findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.buttonCalculate){
            result()
        }
    }

   private fun result(){

       val distancia = findViewById<EditText>(R.id.distancia)
       val preco = findViewById<EditText>(R.id.preco)
       val autonomia = findViewById<EditText>(R.id.autonomia)



       if (validation(distancia , preco , autonomia) ){
           val resultado = calculate(distancia.text.toString().toFloat(),preco.text.toString().toFloat(), autonomia.text.toString().toFloat())
           findViewById<TextView>(R.id.resultado).text = "R$ ${resultado}"

           }else{
               Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG).show()
           }
   }


   private fun calculate(distancia: Float , preco: Float , autonomia: Float) : Float{
          return (distancia * preco) / autonomia

    }

   private fun validation(distancia: EditText , preco: EditText , autonomia: EditText) : Boolean{
       return (distancia.text.isNotEmpty() && preco.text.isNotEmpty() && autonomia.text.isNotEmpty() && distancia.text.toString().toInt() != 0 && preco.text.toString().toInt() != 0 && autonomia.text.toString().toInt() != 0)

    }

}
   private fun validationZero(distancia: Int, preco: Int , autonomia: Int) : Boolean{
       return (distancia != 0 && preco != 0 && autonomia != 0)
   }