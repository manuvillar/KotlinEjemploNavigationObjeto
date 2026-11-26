package es.iesoretania.ejemplonavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import es.iesoretania.ejemplonavigation.databinding.FragmentInicioBinding

/**
 * Destino inicial del grafo (app:startDestination).
 */
class InicioFragment : Fragment() {

    // Patrón de ViewBinding en Fragments: la vista del Fragment se destruye antes
    // que el propio Fragment, así que guardamos el binding en una variable nullable
    // y la ponemos a null en onDestroyView para no "retener" la vista en memoria.
    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navegamos usando el id de la ACCIÓN definida en el grafo.
        // findNavController() busca el NavController del NavHostFragment que nos contiene.
        binding.btnVerLista.setOnClickListener {
            findNavController().navigate(R.id.action_inicio_to_lista)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
