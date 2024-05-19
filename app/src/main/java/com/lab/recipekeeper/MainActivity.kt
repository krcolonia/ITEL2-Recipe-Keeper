package com.lab.recipekeeper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lab.recipekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emptyString = ""

        var recipeName = ""
        var recipeIngredients = ""
        var recipeInstructions = ""
        var insNum:Int = 0

        var recipeAreaTxt:String

        binding.btnAddRecipe.setOnClickListener() {
            if(binding.edtRecipeName.text.isEmpty()) {
                Toast.makeText(applicationContext,"Recipe Name is Empty",Toast.LENGTH_SHORT).show()
            }
            else {
                recipeName += binding.edtRecipeName.text.toString() + "\n"
                recipeAreaTxt = "Recipe for: $recipeName\n\nIngredients:\n$recipeIngredients\n\nInstructions:\n$recipeInstructions"
                binding.edtRecipeArea.setText(recipeAreaTxt)
            }
        }

        binding.btnAddIngredients.setOnClickListener() {
            if(binding.edtIngredients.text.isEmpty()) {
                Toast.makeText(applicationContext,"Ingredient Input is Empty",Toast.LENGTH_SHORT).show()
            }
            else {
                recipeIngredients += "- " + binding.edtIngredients.text.toString() + "\n"
                recipeAreaTxt = "Recipe for: $recipeName\n\nIngredients:\n$recipeIngredients\n\nInstructions:\n$recipeInstructions"
                binding.edtRecipeArea.setText(recipeAreaTxt)
            }
        }

        binding.btnAddInstructions.setOnClickListener() {
            if(binding.edtInstructions.text.isEmpty()) {
                Toast.makeText(applicationContext,"Instruction Input is Empty",Toast.LENGTH_SHORT).show()
            }
            else {
                insNum++
                recipeInstructions += "$insNum. " + binding.edtInstructions.text.toString() + "\n"
                recipeAreaTxt = "Recipe for: $recipeName\n\nIngredients:\n$recipeIngredients\n\nInstructions:\n$recipeInstructions"
                binding.edtRecipeArea.setText(recipeAreaTxt)
            }
        }

        binding.btnSaveRecipe.setOnClickListener() {
            if(binding.edtRecipeName.text.isEmpty() || binding.edtIngredients.text.isEmpty() || binding.edtInstructions.text.isEmpty()) {
                Toast.makeText(applicationContext,"Please complete all Required Information",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext,"Recipe Saved",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnClear.setOnClickListener() {
            insNum = 0
            recipeName = emptyString
            recipeIngredients = emptyString
            recipeInstructions = emptyString
            binding.edtRecipeName.text.clear()
            binding.edtIngredients.text.clear()
            binding.edtInstructions.text.clear()
            binding.edtRecipeArea.text.clear()
            Toast.makeText(applicationContext,"All Inputs Cleared!",Toast.LENGTH_SHORT).show()
        }

        binding.edtRecipeArea.showSoftInputOnFocus = false
    }
}