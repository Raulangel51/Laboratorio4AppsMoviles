package com.example.infoguatelab4versionfinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.infoguatelab4versionfinal.databinding.FragmentArticleBinding
import kotlinx.android.synthetic.*

/**
 * A simple [Fragment] subclass.
 */
class ArticleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentArticleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_article, container,false)

        //jala el nombre que envia el boton de la ventana anterior
        var arg = arguments?.getString("Name")

        if (arg.equals("Antigua") )//los datos que muestra si el dato es antigua
        {
            binding.texto = "La belleza de esta ciudad, Patrimonio Cultural de la Humanidad por la UNESCO,  radica en cada uno de sus detalles. Los que la visitan quedan maravillados con sus atractivos históricos. Antiguos templos y monasterios forman parte de su riqueza.\\n\n" +
                    "        Fundada el 10 de marzo de 1543, La Antigua Guatemala fue declarada Patrimonio Cultural de la Humanidad por la Unesco en el año 1979. Esta bella y mágica ciudad colonial guarda casi quinientos años de historia, con un clima privilegiado y una excepcional vista hacia los volcanes de Fuego y Acatenango. \\n\n" +
                    "        Fue construida en el Valle de Panchoy y nombrada la tercera sede de la capital de Guatemala. En esta ciudad el tiempo se detuvo y quedó atrapado en las gruesas paredes de sus templos, sus monasterios y sus casas coloniales. Esta colorida población aún conserva edificaciones restauradas del siglo XVI y puede ser recorrida a pie a través de sus calles empedradas. \\n\n" +
                    "        Desde el Cerro de la Cruz, ubicado al nororiente de la urbe, La Antigua Guatemala se ve impresionante. Admirable es también el emblemático Volcán de Agua, que ha sido testigo de las glorias y caídas de la población. La belleza de esta ciudad radica en cada uno de sus detalles. Los que la visitan quedan maravillados con sus atractivos históricos, antiguos templos y monasterios que forman parte de su legado."
            binding.title = "Antigua Guatemala"
        }
        if (arg.equals("Retalhuleu"))//los datos que muestra si el dato es reu
        {
            binding.texto = "Creado en 1956, el Parque Nacional Tikal es el parque nacional más antiguo de Guatemala. Se propaga a través de 222 millas cuadradas (575 kilómetros cuadrados) y protege no sólo las ruinas mayas, sino también una enorme franja de bosque tropical y una gran variedad de vida silvestre. De esta manera, ofrece a los viajeros una oportunidad única de combinar las atracciones culturales y ambientales. El parque fue declarado Patrimonio de la Humanidad por la UNESCO en 1979. Su importancia para el patrimonio humano y la historia natural no puede ser exagerada.\\n\n" +
                    "    Tikal fue establecida alrededor de 900 a.C. Se mantuvo bastante pequeña por los próximos 200 años y continúo siendo un asentamiento menor durante la mayor parte del período Preclásico Medio. El período Preclásico tardío vio la terminación de los edificios ceremoniales en la Acrópolis Norte y la pirámide en El Mundo Perdido.\\n\n" +
                    "Alrededor de la época de Cristo, la Gran Plaza de Tikal se estaba construyendo y la ciudad fue creciendo. En el periodo Clásico Temprano, alrededor de 250 d.C, Tikal se había convertido en un centro comercial importante, cultural y religioso. La arquitectura se hizo cada vez más sofisticada y la gran pirámide creció otros 100 pies (30 m) de altura. El arte también despegó alrededor de ese tiempo, los estilos que dominaron durante todo el periodo clásico fueron perfeccionados en estos primeros años."
            binding.title = "Retalhuleu"
        }
        if (arg.equals("Tikal"))//los datos que muestra si el de es tikal
        {
            binding.texto = "Retalhuleu es un departamento de la República de Guatemala, situado en la región suroccidental del país. Tiene una extensión territorial de 1856 kilómetros cuadrados y su población es de aproximadamente 273 328 personas, según el último censo nacional de 2006. Cuenta con nueve municipios y su cabecera departamental es el municipio de Retalhuleu (Diccionario Municipal de Guatemala, 2001).\\n\n" +
                    "Retalhuleu limita al norte con Quetzaltenango, al este con Suchitepéquez, al sur con el Océano Pacífico y al oeste con San Marcos y Quetzaltenango. Sus principales idiomas son el castellano, k’iche’ y cakchiquel. Su temperatura habitual es cálida y su fiesta principal es el 8 de diciembre, en honor a la Virgen de la Inmaculada Concepción. Su fundación fue el 16 de octubre de 1877 (Diccionario Municipal de Guatemala, 2001).\\n\n" +
                    "    Retalhuleu tiene una población de 273 328 personas, de los cuales un 50.4 por ciento vive bajo la línea de pobreza -137 771 personas- y un 9.5 por ciento está considerado dentro de la categoría de pobreza extrema -25 969 personas- (Instituto Nacional de Estadística, 2006)."
            binding.title = "Ruinas de Tikal"
        }

        //metodo para enviar el comentario a la nueva ventana
        binding.button2.setOnClickListener(){view: View ->
            var bun = bundleOf("coment" to binding.editText2.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_articleFragment_to_comentFragment, bun)

        }



        return binding.root
    }


}
