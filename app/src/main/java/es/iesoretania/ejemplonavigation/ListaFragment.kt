package es.iesoretania.ejemplonavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import es.iesoretania.ejemplonavigation.databinding.FragmentListaBinding

/**
 * Lista de planetas. Al pulsar uno, navega al detalle pasándole el OBJETO Planeta.
 */
class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Creamos los objetos Planeta (en una app real vendrían de una BD o de una API)
        val mercurio = Planeta(getString(R.string.mercurio), "El planeta más cercano al Sol.", 57.9)
        val venus = Planeta(getString(R.string.venus), "El planeta más caliente del sistema solar.", 108.2)
        val tierra = Planeta(getString(R.string.tierra), "Nuestro planeta, el único con vida conocida.", 149.6)
        val marte = Planeta(getString(R.string.marte), "El planeta rojo.", 227.9)

        // Cada botón pasa su objeto completo al detalle
        binding.btnMercurio.setOnClickListener { irADetalle(mercurio) }
        binding.btnVenus.setOnClickListener { irADetalle(venus) }
        binding.btnTierra.setOnClickListener { irADetalle(tierra) }
        binding.btnMarte.setOnClickListener { irADetalle(marte) }
    }

    // Navegar CON UN OBJETO como argumento usando Safe Args.
    // ListaFragmentDirections la genera Safe Args a partir del grafo: como el
    // argumento es de tipo Planeta, el método actionListaToDetalle() pide un
    // Planeta. Si le pasamos otra cosa (un String, un Int...), NO compila.
    private fun irADetalle(planeta: Planeta) {
        val accion = ListaFragmentDirections.actionListaToDetalle(planeta)
        findNavController().navigate(accion)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
