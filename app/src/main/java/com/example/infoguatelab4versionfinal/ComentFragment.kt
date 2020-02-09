package com.example.infoguatelab4versionfinal


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.infoguatelab4versionfinal.databinding.FragmentComentBinding

/**
 * A simple [Fragment] subclass.
 */
class ComentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentComentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_coment, container, false)

        //variable que tiene el comentario
        var arg = arguments?.getString("coment")
        binding.coment = arg

        //habilita el menu
        setHasOptionsMenu(true)

        return binding.root
    }

    //infla el menu de share
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.sharing_menu, menu)
    }

    private fun getShareIntent() : Intent {
        var arg = arguments?.getString("coment")

        //crea el intent para mandar a pedir la app para compartir
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, arg)
        return shareIntent
    }

    //usa el starActivity para mandar a pedir las aplicaciones que soportan el intento
    private fun share(){
        startActivity(getShareIntent())
    }

    //manda a llamar a la funcion de share
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        share()
        return super.onOptionsItemSelected(item)
    }


}
