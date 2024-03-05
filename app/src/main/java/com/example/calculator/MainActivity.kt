package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_expression: TextView = findViewById(R.id.btn_expression)
        val btn_result: TextView = findViewById(R.id.btn_result)

        val btn_0: TextView = findViewById(R.id.btn_0)
        val btn_1: TextView = findViewById(R.id.btn_1)
        val btn_2: TextView = findViewById(R.id.btn_2)
        val btn_3: TextView = findViewById(R.id.btn_3)
        val btn_4: TextView = findViewById(R.id.btn_4)
        val btn_5: TextView = findViewById(R.id.btn_5)
        val btn_6: TextView = findViewById(R.id.btn_6)
        val btn_7: TextView = findViewById(R.id.btn_7)
        val btn_8: TextView = findViewById(R.id.btn_8)
        val btn_9: TextView = findViewById(R.id.btn_9)

        val btn_percent: TextView = findViewById(R.id.btn_percent)
        val btn_back: TextView = findViewById(R.id.btn_back)
        val btn_allclear: TextView = findViewById(R.id.btn_allclear)
        val btn_division: TextView = findViewById(R.id.btn_division)
        val btn_multiply: TextView = findViewById(R.id.btn_multiply)
        val btn_minus: TextView = findViewById(R.id.btn_minus)
        val btn_plus: TextView = findViewById(R.id.btn_plus)
        val btn_dot: TextView = findViewById(R.id.btn_dot)
        val btn_equals: TextView = findViewById(R.id.btn_equals)


        btn_0.setOnClickListener {btn_expression.append("0")}
        btn_1.setOnClickListener {btn_expression.append("1")}
        btn_2.setOnClickListener {btn_expression.append("2")}
        btn_3.setOnClickListener {btn_expression.append("3")}
        btn_4.setOnClickListener {btn_expression.append("4")}
        btn_5.setOnClickListener {btn_expression.append("5")}
        btn_6.setOnClickListener {btn_expression.append("6")}
        btn_7.setOnClickListener {btn_expression.append("7")}
        btn_8.setOnClickListener {btn_expression.append("8")}
        btn_9.setOnClickListener {btn_expression.append("9")}


        btn_percent.setOnClickListener {btn_expression.append(":)")}
        btn_division.setOnClickListener {btn_expression.append("/")}
        btn_multiply.setOnClickListener {btn_expression.append("*")}
        btn_minus.setOnClickListener {btn_expression.append("-")}
        btn_plus.setOnClickListener {btn_expression.append("+")}
        btn_dot.setOnClickListener {btn_expression.append(".")}

        btn_result.setOnClickListener {
            val restext = btn_result.text.toString()
            if (restext != "Ошибка" && restext != ""){
                btn_expression.text = restext
                btn_result.text = ""
            }
        }


        btn_allclear.setOnClickListener {
            btn_expression.text= ""
            btn_result.text= ""
        }
        btn_back.setOnClickListener {
            val s = btn_expression.text.toString()
            if (s != "") {
                btn_expression.text = s.substring(0, s.length - 1)
            }
        }


        btn_equals.setOnClickListener {
            val optext = btn_expression.text.toString()
            if (optext != "") {
                try {
                    val expr = ExpressionBuilder(btn_expression.text.toString()).build()
                    val res = expr.evaluate()
                    val longres = res.toLong()
                    if (longres.toDouble() == res) {
                        btn_result.text = longres.toString()
                    } else {
                        btn_result.text = res.toString()
                    }
                } catch (e: Exception) {
                    btn_result.text = "Ошибка"
                }
            }
        }
    }


    }
