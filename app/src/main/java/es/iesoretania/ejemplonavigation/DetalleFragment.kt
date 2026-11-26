package es.iesoretania.ejemplonavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import es.iesoretania.ejemplonavigation.databinding.FragmentDetalleBinding

/**
 * Detalle de un planeta. Recibe el OBJETO Planeta como argumento.
 */
class DetalleFragment : Fragment() {

    private var _binding: FragmentDetalleBinding? = null
    private val binding get() = _binding!!

    // Recogemos los argumentos con Safe Args.
    // "by navArgs()" crea un DetalleFragmentArgs a partir del Bundle de argumentos.
    private val args: DetalleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // args.planeta ya es un objeto Planeta: accedemos a sus propiedades
        val planeta = args.planeta

        binding.tvNombre.text = planeta.nombre
        binding.tvDescripcion.text = planeta.descripcion
        binding.tvDistancia.text = getString(R.string.distancia_sol, planeta.distanciaSol)

        // Ponemos el nombre del planeta como título de la Toolbar
        (requireActivity() as AppCompatActivity).supportActionBar?.title = planeta.nombre

        // Volver al inicio limpiando la pila (ver popUpTo en el grafo).
        // Después, el botón Atrás en Inicio cierra la app en vez de volver aquí.
        binding.btnVolverInicio.setOnClickListener {
            findNavController().navigate(R.id.action_detalle_to_inicio)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
