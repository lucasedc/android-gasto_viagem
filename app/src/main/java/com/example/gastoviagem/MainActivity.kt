package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCalcular.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.btnCalcular)
            calcularGasto()
    }

    private fun calcularGasto() {

        val distance = etDistancia.text.toString()
        val price = etLitro.text.toString()
        val autonomy = etKilometro.text.toString()


        if(validator(distance,price,autonomy)){
            val gasto = distance.toInt()/autonomy.toFloat() * price.toFloat()
            tvGasto.text = "R$ ${"%.2f".format(gasto)}"

        }else{
            Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_LONG).show()
        }


    }

    private fun validator(distance: String, price: String, autonomy: String): Boolean {
        return (distance!= "" && price!= "" && autonomy != "")

    }
}