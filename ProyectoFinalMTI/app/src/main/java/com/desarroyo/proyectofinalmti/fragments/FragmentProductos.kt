package com.desarroyo.practica4


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desarroyo.proyectofinalmti.R
import com.desarroyo.proyectofinalmti.adapters.ProductosAdapter
import com.desarroyo.proyectofinalmti.models.Producto

//import kotlinx.android.synthetic.main.fragment_fragment_one2.*



class FragmentProductos : Fragment() {

    private lateinit var rvMainFood : RecyclerView

    companion object{
        fun newInstance() : FragmentProductos{
            return FragmentProductos()
        }
    }

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_productos, container, false)


        rvMainFood = view.findViewById(R.id.rvMainFood)
        /*
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvMainFood.layoutManager = layoutManager
        */
        rvMainFood.layoutManager = GridLayoutManager(view.context, 1)

        //class Producto(food_name, min_rate, total_rate, price, phone, image)

        val listProducto: ArrayList<Producto> = ArrayList()


        listProducto.add( Producto("AGUA MINERAL CARBOJET",30.00,R.drawable.ref_ciel_mineralizada_b))
        listProducto.add( Producto("COCA COLA CARBOJET",30.00,R.drawable.ref_cocacola_b))
        listProducto.add( Producto("COCA DIETA CARBOJET",30.00,R.drawable.ref_cocalight_b))
        listProducto.add( Producto("FRESCA CARBOJET",30.00,R.drawable.ref_fresca_b))
        listProducto.add( Producto("MANZANA CARBOJET",30.00,R.drawable.ref_manzana_b))
        listProducto.add( Producto("SPRITE CARBOJET",30.00,R.drawable.ref_sprite_b))
        listProducto.add( Producto("GREY GOOSE",105.00,R.drawable.absolut_copa_greygoose))
        listProducto.add( Producto("ABS.AZUL 1LT",1140.00,R.drawable.vodka_bot_absolut1lt))
        listProducto.add( Producto("ABS. AZUL 3/4",1140.00,R.drawable.vodka_bot_absolut34))
        listProducto.add( Producto("BOT. GREY GOOSE  3/4",1510.00,R.drawable.vodka_bot_greygoose))
        listProducto.add( Producto("BOT. STOLICHNAYA  3/4",1000.00,R.drawable.vodka_bot_stolichnaya))
        listProducto.add( Producto("ABS.AZUL",80.00,R.drawable.vodka_copa_absolut))
        listProducto.add( Producto("STOLICHNAYA",80.00,R.drawable.vodka_copa_stolichnaya))
        listProducto.add( Producto("BOT. SMIRNOFF   3/4",600.00,R.drawable.vodka_smirnoff34))
        listProducto.add( Producto("MARTINI DULCE",85.00,R.drawable.martini_dulce))
        listProducto.add( Producto("MARTINI DE MANZANA",85.00,R.drawable.martini_manzana))
        listProducto.add( Producto("MARTINI DE MELON",85.00,R.drawable.martini_melon))
        listProducto.add( Producto("METROPOLITANO",85.00,R.drawable.martini_metro))
        listProducto.add( Producto("MARTINI SECO",85.00,R.drawable.martini_seco))
        listProducto.add( Producto("BLOODY CESAR",85.00,R.drawable.cock_bloodycesar))
        listProducto.add( Producto("BLOODY MARY",85.00,R.drawable.cock_bloodymary))
        listProducto.add( Producto("LUCES HAVANA",85.00,R.drawable.cock_luceshabana))
        listProducto.add( Producto("MAI TAI",85.00,R.drawable.cock_maitai))
        listProducto.add( Producto("MARGARITA",70.00,R.drawable.cock_margarita))
        listProducto.add( Producto("PIÑA COLADA",70.00,R.drawable.cock_pinacolada))
        listProducto.add( Producto("PIÑADA",60.00,R.drawable.cock_pinada))
        listProducto.add( Producto("RUSO BLANCO",85.00,R.drawable.cock_ruso_bco))
        listProducto.add( Producto("RUSO NEGRO",85.00,R.drawable.cock_ruso_negro))
        listProducto.add( Producto("DESCORCHE 300",300.00,R.drawable.descorche250))
        listProducto.add( Producto("DESCORCHE 600",600.00,R.drawable.descorche500))
        listProducto.add( Producto("DON PERIGNON",8000.00,R.drawable.champ_domperignon))
        listProducto.add( Producto("BOT. MOET CHANDON BRUT IMPERIAL",2200.00,R.drawable.champ_moet))
        listProducto.add( Producto("BAGUETTE PAVO",45.00,R.drawable.baguette))
        listProducto.add( Producto("PAPAS CASERAS",30.00,R.drawable.snack_caseras))
        listProducto.add( Producto("CHOCOLATES",25.00,R.drawable.snack_chocolate))
        listProducto.add( Producto("HOT DOG",40.00,R.drawable.snack_hotdog))
        listProducto.add( Producto("Nachos",40.00,R.drawable.snack_nachos))
        listProducto.add( Producto("PALOMITAS GRANDES",40.00,R.drawable.snack_palo_gdes))
        listProducto.add( Producto("APPL.STATE 3/4",840.00,R.drawable.ron_bot_appleton_estate))
        listProducto.add( Producto("APPL.SPECIAL 3/4",540.00,R.drawable.ron_bot_appleton34))
        listProducto.add( Producto("BAC. BCO.  1LT",800.00,R.drawable.ron_bot_bacardi_bco_1lt))
        listProducto.add( Producto("BAC. BCO. 3/4",850.00,R.drawable.ron_bot_bacardi_bco34))
        listProducto.add( Producto("BOT. MALIBU",720.00,R.drawable.ron_bot_malibu))
        listProducto.add( Producto("APPL. STATE",60.00,R.drawable.ron_copa_appleton_estate))
        listProducto.add( Producto("BAC. BCO.",75.00,R.drawable.ron_copa_bacardi_bco))
        listProducto.add( Producto("MALIBU",55.00,R.drawable.ron_copa_malibu))
        listProducto.add( Producto("JAGERMEISTER",75.00,R.drawable.bot_copa_jagermeister))
        listProducto.add( Producto("BOT. BAILEYS",910.00,R.drawable.licior_bot_baileys))
        listProducto.add( Producto("COPA BAILEYS",70.00,R.drawable.licor_baileys_b))
        listProducto.add( Producto("BOT. CINZANO ROJO",600.00,R.drawable.licor_bot_cinzano))
        listProducto.add( Producto("BOT. CONTROY",355.00,R.drawable.licor_bot_controy))
        listProducto.add( Producto("BOT. GRAND MARNIER",1990.00,R.drawable.licor_bot_grandmarnier))
        listProducto.add( Producto("BOT. JAGERMEISTER",720.00,R.drawable.licor_bot_jagermeister))
        listProducto.add( Producto("BOT. MIDORI",960.00,R.drawable.licor_bot_midori))
        listProducto.add( Producto("BOT. SAMBUCA VACCARI NEGRO",999.00,R.drawable.licor_bot_sambuca_black))
        listProducto.add( Producto("CINZANO ROJO",55.00,R.drawable.licor_cinzano_b))
        listProducto.add( Producto("CONTROY",70.00,R.drawable.licor_controy_b))
        listProducto.add( Producto("FRANGELICO",80.00,R.drawable.licor_frangelico_b))
        listProducto.add( Producto("GRAND MARNIER",105.00,R.drawable.licor_grandmarnier_b))
        listProducto.add( Producto("MIDORI",70.00,R.drawable.licor_midori))
        listProducto.add( Producto("CELESTE",850.00,R.drawable.celestetella))
        listProducto.add( Producto("SALENTEIN",1080.00,R.drawable.salenteintella))
        listProducto.add( Producto("XA CABERNET",420.00,R.drawable.tinto_cabernet))
        listProducto.add( Producto("COPA VINO TINTO",70.00,R.drawable.tinto_copa))
        listProducto.add( Producto("GRAN CORONAS",960.00,R.drawable.tinto_grancoronas))
        listProducto.add( Producto("GRAN MURALES",2400.00,R.drawable.tinto_granmuralles))
        listProducto.add( Producto("KENDALL JACKSON",670.00,R.drawable.tinto_kendall))
        listProducto.add( Producto("KWV PIMOTAGE",720.00,R.drawable.tinto_kwv))
        listProducto.add( Producto("ROSEMONT",840.00,R.drawable.tinto_mansovelasco))
        listProducto.add( Producto("MAS LA PLANA",1080.00,R.drawable.tinto_maslaplana))
        listProducto.add( Producto("MONTEPULCIANO",480.00,R.drawable.tinto_montepulciano))
        listProducto.add( Producto("MONTE XANIC CALIXA CABERNET",600.00,R.drawable.tinto_montexanic))
        listProducto.add( Producto("NAVARRO CORREAS COL. PRIV. (ARG)",960.00,R.drawable.tinto_navarro))
        listProducto.add( Producto("ROSEMONT",540.00,R.drawable.tinto_rosemount))
        listProducto.add( Producto("CHYANTY RUFINO",480.00,R.drawable.tinto_ruffino))
        listProducto.add( Producto("GRAN SANGRE DE TORO",540.00,R.drawable.tinto_sangretoro))
        listProducto.add( Producto("SANTA DIGNA",1080.00,R.drawable.tinto_santadigna))
        listProducto.add( Producto("VEGA SICILIANA ALION RIBERA DEL DUERO",2400.00,R.drawable.vegatella))
        listProducto.add( Producto("CORONA",40.00,R.drawable.cerveza_corona_b))
        listProducto.add( Producto("ESTRELLA",30.00,R.drawable.cerveza_estrella_b))
        listProducto.add( Producto("NEGRA MODELO",50.00,R.drawable.cerveza_negramodelo_b))
        listProducto.add( Producto("PACIFICO",40.00,R.drawable.cerveza_pacifico_b))
        listProducto.add( Producto("VICTORIA",40.00,R.drawable.cerveza_victoria_b))
        listProducto.add( Producto("CORONA LIGHT",40.00,R.drawable.coronalight))
        listProducto.add( Producto("C. BAGUETE GDE.",450.00,R.drawable.charolabaguettegde))
        listProducto.add( Producto("C. BAGUETE MED.",300.00,R.drawable.charolabaguettemed))
        listProducto.add( Producto("C. CAR. FRIAS GDE.",540.00,R.drawable.charolacarnesgde))
        listProducto.add( Producto("C. CAR. FRIAS MED.",360.00,R.drawable.charolacarnesmed))
        listProducto.add( Producto("C. FRUTAS F GDE",480.00,R.drawable.charolafrutasgde))
        listProducto.add( Producto("C. FRUTAS F MED",340.00,R.drawable.charolafrutasmed))
        listProducto.add( Producto("CH SUSHI GDE",250.00,R.drawable.charolasushi))
        listProducto.add( Producto("C. VEGETALES GDE",220.00,R.drawable.charolaveggde))
        listProducto.add( Producto("C. VEGETALES MED.",180.00,R.drawable.charolavegmed))
        listProducto.add( Producto("LATOUR CHABLIS",840.00,R.drawable.bco_chablis))
        listProducto.add( Producto("LIEBFRAUMILCH",540.00,R.drawable.bco_liebfraumilch))
        listProducto.add( Producto("VIÑA ESMERALDA 700",840.00,R.drawable.bco_vinaesme_750))
        listProducto.add( Producto("YELOW TAIL",660.00,R.drawable.bco_yellowtail))
        listProducto.add( Producto("COPA VINO BLANCO",65.00,R.drawable.vinobco))
        listProducto.add( Producto("BOT. TORRES 10 3/4",1050.00,R.drawable.brandy_bot_torres10))
        listProducto.add( Producto("BOT. TORRES 20 3/4",2160.00,R.drawable.brandy_bot_torres20))
        listProducto.add( Producto("BRAN.TORRES 10",90.00,R.drawable.brandy_copa_torres10))
        listProducto.add( Producto("TORRES 20",150.00,R.drawable.brandy_copa_torres20))
        listProducto.add( Producto("AGUA CIEL NATURAL",30.00,R.drawable.ju_agua_b))
        listProducto.add( Producto("CLAMATO",30.00,R.drawable.ju_clamato_b))
        listProducto.add( Producto("PERRIER 330 ml",40.00,R.drawable.perrier))
        listProducto.add( Producto("AGUA MINERAL CIEL",30.00,R.drawable.ref_ciel_mineralizada_b))
        listProducto.add( Producto("COCA COLA",30.00,R.drawable.ref_cocacola_b))
        listProducto.add( Producto("COCA DIETA",30.00,R.drawable.ref_cocalight_b))
        listProducto.add( Producto("COCA ZERO",30.00,R.drawable.ref_cocazero))
        listProducto.add( Producto("FANTA",30.00,R.drawable.ref_fanta_b))
        listProducto.add( Producto("FRESCA",30.00,R.drawable.ref_fresca_b))
        listProducto.add( Producto("LIMONADA",50.00,R.drawable.ref_limonada))
        listProducto.add( Producto("MANZANA",30.00,R.drawable.ref_manzana_b))
        listProducto.add( Producto("AGUA QUINA SEAGRAM´S",25.00,R.drawable.ref_seagrams_quina_b))
        listProducto.add( Producto("SPRITE",30.00,R.drawable.ref_sprite_b))
        listProducto.add( Producto("BOT. BERINGER WHITE ZINFANDEL (EUA)",660.00,R.drawable.rosado_bot_beringer))
        listProducto.add( Producto("BERINGER WHITE ZINFANDEL (EUA)",90.00,R.drawable.rosado_copa_beringer))
        listProducto.add( Producto("BOT. BEEFEATER",1200.00,R.drawable.gin_bot_beefeater))
        listProducto.add( Producto("BOT. BOMBAY",1320.00,R.drawable.gin_bot_bombay))
        listProducto.add( Producto("BOT. TANQUERAY",1130.00,R.drawable.gin_bot_tanqueray))
        listProducto.add( Producto("BEEFEATER",80.00,R.drawable.gin_copa_beefeater))
        listProducto.add( Producto("BOMBAY",90.00,R.drawable.gin_copa_bombay))
        listProducto.add( Producto("TANQUERAY",80.00,R.drawable.gin_copa_tanqueray))
        listProducto.add( Producto("OSO NEGRO",45.00,R.drawable.vodka_copaosonegro))
        listProducto.add( Producto("BOT. BUCHANANS RED SEAL",7030.00,R.drawable.whis_bot_buchanans_redseal))
        listProducto.add( Producto("BOT. BUCHANANS 12 LITRO",1920.00,R.drawable.whis_bot_buchanans121lt))
        listProducto.add( Producto("BOT. BUCHANANS 12",1800.00,R.drawable.whis_bot_buchanans1234))
        listProducto.add( Producto("BOT. BUCHANANS 18",3250.00,R.drawable.whis_bot_buchanans18))
        listProducto.add( Producto("BOT. JACK DANIELS 1 LT",1510.00,R.drawable.whis_bot_jackdaniels1lt))
        listProducto.add( Producto("BOT. JACK DANIELS 3/4",1320.00,R.drawable.whis_bot_jackdaniels34))
        listProducto.add( Producto("BOT. JW ETIQ. NEGRA",1650.00,R.drawable.whis_bot_jwblack))
        listProducto.add( Producto("BOT. JW ETIQ. ROJA 3/4",1200.00,R.drawable.whis_bot_jwred))
        listProducto.add( Producto("BUCHANANS RED SEAL",450.00,R.drawable.whis_copa_buchanans_redseal))
        listProducto.add( Producto("BUCHANANS 12",140.00,R.drawable.whis_copa_buchanans12))
        listProducto.add( Producto("BUCHANANS 18",200.00,R.drawable.whis_copa_buchanans18))
        listProducto.add( Producto("JACK DANIELS",85.00,R.drawable.whis_copa_jackdaniels))
        listProducto.add( Producto("JW ETIQ. NEGRA",130.00,R.drawable.whis_jwblack))
        listProducto.add( Producto("JW ETIQ. ROJA",100.00,R.drawable.whis_jwred))
        listProducto.add( Producto("JUGO DE ARANDANO",30.00,R.drawable.ju_arandano_b))
        listProducto.add( Producto("JUGO DE MANZANA",30.00,R.drawable.ju_manzana_b))
        listProducto.add( Producto("JUGO DE NARANJA",30.00,R.drawable.ju_naranja_b))
        listProducto.add( Producto("JUGO DE PIÑA",30.00,R.drawable.ju_pina_b))
        listProducto.add( Producto("RED BULL",50.00,R.drawable.ju_redbull_b))
        listProducto.add( Producto("JUGO DE UVA",30.00,R.drawable.ju_uva_b))
        listProducto.add( Producto("CAFÉ CHICO",15.00,R.drawable.cafe_ch))
        listProducto.add( Producto("CAFÉ GRANDE",20.00,R.drawable.cafe_gde))
        listProducto.add( Producto("BOT. COURVOSIER V.S.O.P.",1630.00,R.drawable.cog_bot_corvoisier))
        listProducto.add( Producto("BOT. MARTELL V.S.O.P 1 LT",2400.00,R.drawable.cog_bot_martell1lt))
        listProducto.add( Producto("BOT. MARTELL V.S.O.P 3/4",1950.00,R.drawable.cog_bot_martell34))
        listProducto.add( Producto("MARTELL V.S.O.P",160.00,R.drawable.cog_copa_martell))


        val adapter = ProductosAdapter(view.context,listProducto)
        rvMainFood.adapter = adapter

        return view
    }



    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context != null) {




        }
    }


}
