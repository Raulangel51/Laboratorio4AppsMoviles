package com.example.infoguatelab4versionfinal


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.infoguatelab4versionfinal.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {
    //variables a utilizar
    lateinit var mostrar: TextView
    lateinit var text: TextView
    lateinit var  nombre: EditText
    lateinit var intento: Intent
    var cont = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_title, container, false)
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        //metodo para mostrar y quitar el nombre
        binding.floatingActionButton.setOnClickListener {
            if(cont == 0){
                //se le coloca el nombre y se hace vivisble
                binding.nombre = binding.editTextPedirNombre.text.toString()
                binding.editTextPedirNombre.visibility = View.GONE
                binding.textViewNombre.visibility = View.GONE
                binding.textViewMostrar.visibility = View.VISIBLE
                cont++
            }
            else{
                //se regresa a la normalidad
                binding.textViewNombre.visibility = View.VISIBLE
                binding.editTextPedirNombre.visibility = View.VISIBLE
                binding.editTextPedirNombre.setText("")
                binding.textViewMostrar.setText("")
                binding.textViewMostrar.visibility = View.GONE
                cont=0
            }
        }

        //el metodo para que se muesstre la informacion de antigua
        binding.buttonAntigua.setOnClickListener(){view: View ->
            var arg = bundleOf("Name" to binding.buttonAntigua.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_titleFragment2_to_articleFragment, arg)

        }

        //metodo para que se muestra la informacion de reu
        binding.buttonReu.setOnClickListener(){view: View ->
            var arg = bundleOf("Name" to binding.buttonReu.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_titleFragment2_to_articleFragment, arg)
        }

        //metodo para que se muestre la informacion de tikal
        binding.buttonTikal.setOnClickListener(){view: View ->
            var arg = bundleOf("Name" to binding.buttonTikal.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_titleFragment2_to_articleFragment, arg)
        }

        //permite que se vea el menu de about
        setHasOptionsMenu(true)

        return binding.root
    }

    //abre el menu para mostrar about
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    //infla la pestaña de about
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController()) || super.onOptionsItemSelected(item)

    }


}
