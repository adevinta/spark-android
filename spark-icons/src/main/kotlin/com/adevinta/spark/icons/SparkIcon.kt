/*
 * Copyright (c) 2023 Adevinta
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.adevinta.spark.icons

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

public interface IconDrawableRes {
    @get:DrawableRes
    public val drawableId: Int
}

public interface IconVector {
    public val imageVector: ImageVector
}

@Stable
public sealed class SparkIcon(@DrawableRes override val drawableId: Int) : IconDrawableRes {
    public sealed class Account(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Account : SparkIcon.Account(R.drawable.spark_icons_account)
        public object Activity : SparkIcon.Account(R.drawable.spark_icons_activity)
        public object Booking : SparkIcon.Account(R.drawable.spark_icons_booking)

        public object BurgerMenu : SparkIcon.Account(R.drawable.spark_icons_menu)
        @Deprecated("This Icon is a part of Arrows", replaceWith = ReplaceWith("Arrows.Close.Full"))
        public object Close : SparkIcon.Account(R.drawable.spark_icons_close_full)
        public sealed class Cv(@DrawableRes override val drawableId: Int) : SparkIcon.Account(drawableId) {
            public object Default : Cv(R.drawable.spark_icons_cv)
            public object Outlined : Cv(R.drawable.spark_icons_cv_outline)
            public object Disabled : Cv(R.drawable.spark_icons_sales_prospecting)
        }

        public object France : SparkIcon.Account(R.drawable.spark_icons_france)
        public object House : SparkIcon.Account(R.drawable.spark_icons_house)
        public object Identity : SparkIcon.Account(R.drawable.spark_icons_identity)
        public object Key : SparkIcon.Account(R.drawable.spark_icons_key)
        public object Listing : SparkIcon.Account(R.drawable.spark_icons_listing)
        public sealed class Offers(@DrawableRes override val drawableId: Int) : SparkIcon.Account(drawableId) {
            public object Default : Offers(R.drawable.spark_icons_offers)
            public object Outlined : Offers(R.drawable.spark_icons_offers_outline)
        }

        public object SalesProspecting : SparkIcon.Account(R.drawable.spark_icons_sales_prospecting)
        public sealed class SecurePayment(@DrawableRes override val drawableId: Int) : SparkIcon.Account(drawableId) {
            public object Default : SecurePayment(R.drawable.spark_icons_secure_payment)
            public object Outlined : SecurePayment(R.drawable.spark_icons_secure_payment_outline)
        }

        public sealed class Shop(@DrawableRes override val drawableId: Int) : SparkIcon.Account(drawableId) {
            public object Default : Shop(R.drawable.spark_icons_shop)
            public object Outlined : Shop(R.drawable.spark_icons_shop_outline)
        }

        public object Store : SparkIcon.Account(R.drawable.spark_icons_store)
        public object ThumbUp : SparkIcon.Account(R.drawable.spark_icons_thumbs_up)
        public sealed class Work(@DrawableRes override val drawableId: Int) : SparkIcon.Account(drawableId) {
            public object Default : Work(R.drawable.spark_icons_suitcase_filled)
            public object Outlined : Work(R.drawable.spark_icons_suitcase)
        }
    }

    public sealed class Actions(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Calculate : Actions(R.drawable.spark_icons_calculate)
        public object Copy : Actions(R.drawable.spark_icons_copy)
        public sealed class Eyes(@DrawableRes override val drawableId: Int) : Actions(drawableId) {
            public sealed class Filled(@DrawableRes override val drawableId: Int) : Eyes(drawableId) {
                public object Enabled : Filled(R.drawable.spark_icons_eyes)
                public object Disabled : Filled(R.drawable.spark_icons_eyes_disabled)
            }

            public sealed class Outlined(@DrawableRes override val drawableId: Int) : Eyes(drawableId) {
                public object Enabled : Outlined(R.drawable.spark_icons_eyes_outline)
                public object Disabled : Outlined(R.drawable.spark_icons_eyes_disabled_outline)
            }
        }

        public sealed class Favorite(@DrawableRes override val drawableId: Int) : Actions(drawableId) {
            public object Default : Favorite(R.drawable.spark_icons_heart)
            public object Outlined : Favorite(R.drawable.spark_icons_heart_outline)
        }

        public object Filter : Actions(R.drawable.spark_icons_filter)
        public object Flashlight : Actions(R.drawable.spark_icons_flashlight)
        public object More : Actions(R.drawable.spark_icons_more_menu)

        public object Pause : Actions(R.drawable.spark_icons_pause)
        public object Play : Actions(R.drawable.spark_icons_play)
        public sealed class Pen(@DrawableRes override val drawableId: Int) : Actions(drawableId) {
            public object Default : Pen(R.drawable.spark_icons_pen)
            public object Outlined : Pen(R.drawable.spark_icons_pen_outline)
        }

        public object Print : Actions(R.drawable.spark_icons_print)
        public object Refresh : Actions(R.drawable.spark_icons_refresh)
        public object Scan : Actions(R.drawable.spark_icons_scan)
        public object Search : Actions(R.drawable.spark_icons_search)
        public sealed class Trash(@DrawableRes override val drawableId: Int) : Actions(drawableId) {
            public object Default : Trash(R.drawable.spark_icons_trash)
            public object Outlined : Trash(R.drawable.spark_icons_trash_outline)
            public object Close : Trash(R.drawable.spark_icons_trash_close)
        }

        public sealed class Wheel(@DrawableRes override val drawableId: Int) : Actions(drawableId) {
            public object Default : Wheel(R.drawable.spark_icons_wheel)
            public object Outlined : Wheel(R.drawable.spark_icons_wheel_outline)
        }
    }

    public sealed class Arrows(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public sealed class Arrow(@DrawableRes override val drawableId: Int) : Arrows(drawableId) {
            public object Left : Arrow(R.drawable.spark_icons_arrow_left)
            public object Right : Arrow(R.drawable.spark_icons_arrow_right)
        }

        public sealed class Chevron(@DrawableRes override val drawableId: Int) : Arrows(drawableId) {
            public object Left : Chevron(R.drawable.spark_icons_chevron_left)
            public object Right : Chevron(R.drawable.spark_icons_chevron_right)
            public object Up : Chevron(R.drawable.spark_icons_chevron_up)
            public object Down : Chevron(R.drawable.spark_icons_chevron_down)
        }

        public sealed class DoubleChevron(@DrawableRes override val drawableId: Int) : Arrows(drawableId) {
            public object Left : Arrow(R.drawable.spark_icons_chevron_double_left)
            public object Right : Arrow(R.drawable.spark_icons_chevron_double_right)
        }

        public sealed class Close(@DrawableRes override val drawableId: Int) : Arrows(drawableId) {
            public object Default : Close(R.drawable.spark_icons_close)
            public object Full : Close(R.drawable.spark_icons_close_full)
        }

        public sealed class Chart(@DrawableRes override val drawableId: Int) : Arrows(drawableId) {
            public object Up : Chevron(R.drawable.spark_icons_chart_up)
            public object Down : Chevron(R.drawable.spark_icons_chart_down)
        }
    }

    public sealed class Calendar(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Booking : Calendar(R.drawable.spark_icons_calendar_booking)
        public object Default : Calendar(R.drawable.spark_icons_calendar_simple)
        public object Valid : Calendar(R.drawable.spark_icons_calendar_valid)
    }

    public sealed class Categories(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Apartment : Categories(R.drawable.spark_icons_apartment)
        public object Car : Categories(R.drawable.spark_icons_car)
        public object Couch : Categories(R.drawable.spark_icons_couch)
        public object Computer : Categories(R.drawable.spark_icons_computer)
        public object Clothes : Categories(R.drawable.spark_icons_mode)
        public object Equipment : Categories(R.drawable.spark_icons_equipment)
        public object Ground : Categories(R.drawable.spark_icons_ground)
        public object Hobbies : Categories(R.drawable.spark_icons_hobbies)
        public object Holidays : Categories(R.drawable.spark_icons_holidays)
        public object House : Categories(R.drawable.spark_icons_house)
        public object Land : Categories(R.drawable.spark_icons_land)
        public object Multimedia : Categories(R.drawable.spark_icons_multimedia)
        public object Parking : Categories(R.drawable.spark_icons_parking)
        public object Pending : Categories(R.drawable.spark_icons_pending)
        public object Pets : Categories(R.drawable.spark_icons_pets)
        public object Services : Categories(R.drawable.spark_icons_services)
        public object Suitcase : Categories(R.drawable.spark_icons_suitcase)
    }

    public sealed class Contact(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public sealed class Mail(@DrawableRes override val drawableId: Int) : Contact(drawableId) {
            public object Default : Mail(R.drawable.spark_icons_mail)
            public object Outlined : Mail(R.drawable.spark_icons_mail_outline)
        }

        public sealed class Micro(@DrawableRes override val drawableId: Int) : Contact(drawableId) {
            public object Default : Micro(R.drawable.spark_icons_micro)
            public object Outlined : Micro(R.drawable.spark_icons_micro_outline)
            public object Disabled : Micro(R.drawable.spark_icons_micro_off)
        }

        public sealed class Message(@DrawableRes override val drawableId: Int) : Contact(drawableId) {
            public object Default : Message(R.drawable.spark_icons_message)
            public object Outlined : Message(R.drawable.spark_icons_message_outline)
        }

        public sealed class Phone(@DrawableRes override val drawableId: Int) : Contact(drawableId) {
            public object Default : Phone(R.drawable.spark_icons_phone)
            public object Outlined : Phone(R.drawable.spark_icons_phone_outine)
            public object Message : Phone(R.drawable.spark_icons_phone_message)
        }

        public object SendMessage : Contact(R.drawable.spark_icons_send_message)
    }

    public sealed class Criterias(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public sealed class Animaux(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Age : Animaux(R.drawable.spark_icons_animal_age)
            public object Loof : Animaux(R.drawable.spark_icons_animal_race)
            public object Offre : Animaux(R.drawable.spark_icons_animal_offer_nature)
            public object Portee : Animaux(R.drawable.spark_icons_animal_litter)
            public object Tatouage : Animaux(R.drawable.spark_icons_animal_identification)
            public object TypeDeLOffre : Animaux(R.drawable.spark_icons_animal_type)
            public object Vaccin : Animaux(R.drawable.spark_icons_animal_vaccinated)
        }

        public sealed class Automobile(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Loof : Automobile(R.drawable.spark_icons_animal_race)
            public object Bateau : Automobile(R.drawable.spark_icons_boat)
            public object Carburant : Automobile(R.drawable.spark_icons_fuel)
            public object Couleur : Automobile(R.drawable.spark_icons_color)

            public object Cylindree : Automobile(R.drawable.spark_icons_engine)
            public object Energie : Automobile(R.drawable.spark_icons_energy)
            public object Puissance : Automobile(R.drawable.spark_icons_horse_power)

            public object Kilometrage : Automobile(R.drawable.spark_icons_mileage)
            public object Marque : Automobile(R.drawable.spark_icons_model)
            public object Moto : Automobile(R.drawable.spark_icons_motobike)

            public object Permis : Automobile(R.drawable.spark_icons_car_licence)
            public object Places : Automobile(R.drawable.spark_icons_seats)
            public object Portes : Automobile(R.drawable.spark_icons_doors)
            public object Regdate : Automobile(R.drawable.spark_icons_date)
            public object Type : Automobile(R.drawable.spark_icons_car_type)
            public object Vitesse : Automobile(R.drawable.spark_icons_gearbox)
            public object Coffre : Automobile(R.drawable.spark_icons_trunk)
        }

        public sealed class Emploi(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object EducationalLevel : Emploi(R.drawable.spark_icons_job_study)
            public object Experience : Emploi(R.drawable.spark_icons_job_experience)
            public object Fonction : Emploi(R.drawable.spark_icons_job_duty)
            public object Salaire : Emploi(R.drawable.spark_icons_job_salary)
            public object Secteur : Emploi(R.drawable.spark_icons_job_field)
            public object Temps : Emploi(R.drawable.spark_icons_job_time)
            public object Type : Emploi(R.drawable.spark_icons_job_contract)
        }

        public sealed class Generique(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Defaut1 : Generique(R.drawable.spark_icons_like)
            public object Defaut2 : Generique(R.drawable.spark_icons_criteria)
            public object Donate : Emploi(R.drawable.spark_icons_donate)
            public object Smoking : Generique(R.drawable.spark_icons_smoking)
            public object Localisation : Generique(R.drawable.spark_icons_localisation)
            public object Delivery : Generique(R.drawable.spark_icons_delivery)
        }

        public sealed class Immobilier(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Classe : Immobilier(R.drawable.spark_icons_energy_rate)
            public object Ges : Immobilier(R.drawable.spark_icons_ges)
            public object Honoraires : Immobilier(R.drawable.spark_icons_fai)
            public object Meuble : Immobilier(R.drawable.spark_icons_furnished)
            public object Pieces : Immobilier(R.drawable.spark_icons_rooms)
            public object Reference : Immobilier(R.drawable.spark_icons_reference)
            public object Surface : Immobilier(R.drawable.spark_icons_square)
            public object TypeDeBien : Immobilier(R.drawable.spark_icons_real_estate_type)
            public object TypeDeVente : Immobilier(R.drawable.spark_icons_real_estate_sale_type)
        }

        public sealed class ImmobilierNeuf(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Balcon : ImmobilierNeuf(R.drawable.spark_icons_balcony)
            public object Cave : ImmobilierNeuf(R.drawable.spark_icons_cellar)
            public object Duplex : ImmobilierNeuf(R.drawable.spark_icons_duplex)
            public object Etage : ImmobilierNeuf(R.drawable.spark_icons_floor)
            public object Garage : ImmobilierNeuf(R.drawable.spark_icons_garage)
            public object Jardin : ImmobilierNeuf(R.drawable.spark_icons_garden)
            public object Loggia : ImmobilierNeuf(R.drawable.spark_icons_loggia)
            public object Orientation : ImmobilierNeuf(R.drawable.spark_icons_direction)
            public object Parking : ImmobilierNeuf(R.drawable.spark_icons_park_sign)
            public object Terrasse : ImmobilierNeuf(R.drawable.spark_icons_terrace)
        }

        public sealed class Location(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Cave : Location(R.drawable.spark_icons_location_cave)
            public object Calme : Location(R.drawable.spark_icons_location_calme)
            public object Cave2 : Location(R.drawable.spark_icons_location_cave_2)
            public object Chemine : Location(R.drawable.spark_icons_location_chemine)
            public object DernierEtage : Location(R.drawable.spark_icons_location_dernieretage)
            public object Digicode : Location(R.drawable.spark_icons_location_digicode)
            public object BaiesVitrees : Location(R.drawable.spark_icons_location_baiesvitrees)
            public object Concierge : Location(R.drawable.spark_icons_location_concierge)
            public object Combles : Location(R.drawable.spark_icons_location_combles)
            public object BeauBatiment : Location(R.drawable.spark_icons_location_beaubatiment)
            public object Interphone : Location(R.drawable.spark_icons_location_interphone)
            public object Loft : Location(R.drawable.spark_icons_location_loft)
            public object Lumineux : Location(R.drawable.spark_icons_location_lumineux)
            public object Mitoyen : Location(R.drawable.spark_icons_location_mitoyen)
            public object Mouture : Location(R.drawable.spark_icons_location_moulure)
            public object Parquet : Location(R.drawable.spark_icons_location_parquet)
            public object Penderie : Location(R.drawable.spark_icons_location_penderie)
            public object Metro : Location(R.drawable.spark_icons_location_metro)
            public object Magasin : Location(R.drawable.spark_icons_location_magasin)
            public object Douche : Location(R.drawable.spark_icons_location_douche)
            public object Renove : Location(R.drawable.spark_icons_location_renovee)
            public object Baignoire : Location(R.drawable.spark_icons_location_baignoire)
            public object Vue : Location(R.drawable.spark_icons_location_vue)
            public object VueMer : Location(R.drawable.spark_icons_location_vue_mer)
            public object Wc : Location(R.drawable.spark_icons_location_wc)
            public object Ascenseur : Location(R.drawable.spark_icons_elevator)
            public object ChargesComprises : Location(R.drawable.spark_icons_location_charges_comprises)
        }

        public sealed class Loisirs(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Jouet : Loisirs(R.drawable.spark_icons_jouet)
            public object BicycleType : Loisirs(R.drawable.spark_icons_bicycle)
            public object ToysProduct : Loisirs(R.drawable.spark_icons_toy_product)
        }

        public sealed class Maison(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object DiyProduct : Maison(R.drawable.spark_icons_maison_diy_product)
            public object DiyType : Maison(R.drawable.spark_icons_maison_diy_type)
            public object HomeAppliancesProduct : Maison(R.drawable.spark_icons_maison_homeappliance_product)
            public object HomeAppliancesType : Maison(R.drawable.spark_icons_maison_homeappliance_type)
            public object GardeningProduct : Maison(R.drawable.spark_icons_maison_gardening_product)
            public object GardeningType : Maison(R.drawable.spark_icons_maison_gardening_type)
            public object LinensProduct : Maison(R.drawable.spark_icons_linens_product)
            public object LinensType : Maison(R.drawable.spark_icons_linens_type)
            public object TableArtMaterial : Maison(R.drawable.spark_icons_maison_tableart_material)
            public object TableArtProduct : Maison(R.drawable.spark_icons_maison_tableart_product)
            public object FournitureType : Maison(R.drawable.spark_icons_furniture_type)
        }

        public sealed class Mode(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object EquipementBebe : Mode(R.drawable.spark_icons_baby_equipment_type)
            public object Couleur : Mode(R.drawable.spark_icons_color)
            public object Etat : Mode(R.drawable.spark_icons_clothing_condition)
            public object Marque : Mode(R.drawable.spark_icons_brand)
            public object Matiere : Mode(R.drawable.spark_icons_clothing_material)
            public object Luxe : Mode(R.drawable.spark_icons_accessories_material)
            public object Pointure : Mode(R.drawable.spark_icons_shoe_size)
            public object Taille : Mode(R.drawable.spark_icons_clothing_size)
            public object Bijoux : Mode(R.drawable.spark_icons_accessories_type_2)
            public object Chaussure : Mode(R.drawable.spark_icons_shoe_type)
            public object Vetements : Mode(R.drawable.spark_icons_clothing_type)
            public object Univers : Mode(R.drawable.spark_icons_people)
        }

        public sealed class Multimedia(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Etat : Multimedia(R.drawable.spark_icons_item_condition)
            public object Memoire : Multimedia(R.drawable.spark_icons_phone_memory)
            public object Modele : Multimedia(R.drawable.spark_icons_phone_type)
            public object Couleur : Multimedia(R.drawable.spark_icons_color)
            public object Marque : Multimedia(R.drawable.spark_icons_phone_type)
            public object Type : Multimedia(R.drawable.spark_icons_video_game_type)
        }

        public sealed class Vacances(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public object Animaux : Vacances(R.drawable.spark_icons_pet_accepted)
            public object Capacite : Vacances(R.drawable.spark_icons_people)
            public object Chambres : Vacances(R.drawable.spark_icons_bedrooms)
            public object Arrive : Vacances(R.drawable.spark_icons_check_in_out)
            public object Depart : Vacances(R.drawable.spark_icons_check_in_out)
            public object NombreEtoiles : Vacances(R.drawable.spark_icons_housing_ranking)
            public object Climatisation : Vacances(R.drawable.spark_icons_aircooler)
            public object SalleSport : Vacances(R.drawable.spark_icons_gym)
            public object PetitDejeune : Vacances(R.drawable.spark_icons_breakfast)
            public object Spa : Vacances(R.drawable.spark_icons_spa)
            public object Tv : Vacances(R.drawable.spark_icons_television)
            public object Acceuil : Vacances(R.drawable.spark_icons_welcome)
            public object Wifi : Vacances(R.drawable.spark_icons_wifi)
            public object LabelSanitaire2 : Vacances(R.drawable.spark_icons_covid)
            public object TypeLogement : Vacances(R.drawable.spark_icons_real_estate_type)
            public object Jardin : Vacances(R.drawable.spark_icons_garden)
            public object Parking : Vacances(R.drawable.spark_icons_park)
            public object Piscine : Vacances(R.drawable.spark_icons_swimming_pool)
            public object Accessories : Vacances(R.drawable.spark_icons_accessories_type)
            public object Date : Vacances(R.drawable.spark_icons_date)
        }

        public sealed class MaterialTools(@DrawableRes override val drawableId: Int) : Criterias(drawableId) {
            public sealed class Tools(@DrawableRes override val drawableId: Int) : MaterialTools(drawableId) {
                public object Agriculture : Tools(R.drawable.spark_icons_agriculture)
            }
        }
    }

    public sealed class Flags(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object FlagAT : Flags(R.drawable.spark_icons_flag_at)
        public object FlagBE : Flags(R.drawable.spark_icons_flag_be)
        public object FlagBR : Flags(R.drawable.spark_icons_flag_br)
        public object FlagBY : Flags(R.drawable.spark_icons_flag_by)
        public object FlagCH : Flags(R.drawable.spark_icons_flag_ch)
        public object FlagCL : Flags(R.drawable.spark_icons_flag_cl)
        public object FlagCO : Flags(R.drawable.spark_icons_flag_co)
        public object FlagDO : Flags(R.drawable.spark_icons_flag_do)
        public object FlagES : Flags(R.drawable.spark_icons_flag_es)
        public object FlagFI : Flags(R.drawable.spark_icons_flag_fi)
        public object FlagFR : Flags(R.drawable.spark_icons_flag_fr)
        public object FlagHU : Flags(R.drawable.spark_icons_flag_hu)
        public object FlagID : Flags(R.drawable.spark_icons_flag_id)
        public object FlagIE : Flags(R.drawable.spark_icons_flag_ie)
        public object FlagIT : Flags(R.drawable.spark_icons_flag_it)
        public object FlagMA : Flags(R.drawable.spark_icons_flag_ma)
        public object FlagMX : Flags(R.drawable.spark_icons_flag_mx)
        public object FlagMY : Flags(R.drawable.spark_icons_flag_my)
        public object FlagPT : Flags(R.drawable.spark_icons_flag_pt)
        public object FlagSE : Flags(R.drawable.spark_icons_flag_se)
        public object FlagTN : Flags(R.drawable.spark_icons_flag_tn)
        public object FlagVN : Flags(R.drawable.spark_icons_flag_vn)
    }

    public sealed class Images(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public sealed class Camera(@DrawableRes override val drawableId: Int) : Images(drawableId) {
            public object Default : Camera(R.drawable.spark_icons_camera)
            public object Outline : Camera(R.drawable.spark_icons_camera_outline)
            public object More : Camera(R.drawable.spark_icons_camera_more)
        }

        public object Library : Images(R.drawable.spark_icons_library)
        public sealed class NewAd(@DrawableRes override val drawableId: Int) : Images(drawableId) {
            public object Default : NewAd(R.drawable.spark_icons_new_ad)
            public object Outline : NewAd(R.drawable.spark_icons_new_ad_outline)
        }

        public object NoPhoto : Images(R.drawable.spark_icons_no_photo1)
        public object ErrorPhoto : Images(R.drawable.spark_icons_error_photo)

        public object NoPhoto2 : Images(R.drawable.spark_icons_no_photo2)
        public object Rotate : Images(R.drawable.spark_icons_photo_rotate)
    }

    public sealed class Infos(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Camera : Infos(R.drawable.spark_icons_camera)

        public object Block : Infos(R.drawable.spark_icons_block)

        public sealed class Alert(@DrawableRes override val drawableId: Int) : Infos(drawableId) {
            public object Default : Alert(R.drawable.spark_icons_alerte)
            public object Outline : Alert(R.drawable.spark_icons_alert_outline)
        }

        public sealed class Ask(@DrawableRes override val drawableId: Int) : Infos(drawableId) {
            public object Default : Ask(R.drawable.spark_icons_ask)
            public object Outline : Ask(R.drawable.spark_icons_ask_outline)
        }

        public sealed class Info(@DrawableRes override val drawableId: Int) : Infos(drawableId) {
            public object Default : Info(R.drawable.spark_icons_info)
            public object Outline : Info(R.drawable.spark_icons_info_outline)
        }

        public sealed class LightBulb(@DrawableRes override val drawableId: Int) : Infos(drawableId) {
            public object Default : LightBulb(R.drawable.spark_icons_lightbulb)
            public object Outline : LightBulb(R.drawable.spark_icons_lightbulb_outline)
        }

        public sealed class Lock(@DrawableRes override val drawableId: Int) : Infos(drawableId) {
            public object Default : Lock(R.drawable.spark_icons_lock)
            public object Outline : Lock(R.drawable.spark_icons_lock_outline)
            public object Open : Lock(R.drawable.spark_icons_open)
        }

        public object Warning : Infos(R.drawable.spark_icons_warning)
    }

    public sealed class Delivery(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object DeliveryHand : Delivery(R.drawable.spark_icons_delivery_hands)
        public object DeliveryOutline : Delivery(R.drawable.spark_icons_box_outline)
        public object Truck : Delivery(R.drawable.spark_icons_delivery_truck)
        public sealed class Mailbox(@DrawableRes override val drawableId: Int) : Delivery(drawableId) {
            public sealed class Close(@DrawableRes override val drawableId: Int) : Mailbox(drawableId) {
                public object Down : Close(R.drawable.spark_icons_delivery_mailbox_closed_down)
                public object Up : Close(R.drawable.spark_icons_delivery_mailbox_closed_up)
            }

            public sealed class Open(@DrawableRes override val drawableId: Int) : Mailbox(drawableId) {
                public object Down : Open(R.drawable.spark_icons_delivery_mailbox_open_down)
                public object Up : Open(R.drawable.spark_icons_delivery_mailbox_open_up)
            }
        }
    }

    public sealed class Map(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object ThreeSixty : Map(R.drawable.spark_icons_three_sixty)
        public object Bike : Map(R.drawable.spark_icons_bike)
        public object Drag : Map(R.drawable.spark_icons_drag)
        public object Expand : Map(R.drawable.spark_icons_expand)
        public object Geoloc : Map(R.drawable.spark_icons_geoloc)
        public object Hotel : Map(R.drawable.spark_icons_hotel)

        public sealed class Marker(@DrawableRes override val drawableId: Int) : Map(drawableId) {
            public object Default : Marker(R.drawable.spark_icons_marker)
            public object Outline : Marker(R.drawable.spark_icons_marker_outline)
        }

        public sealed class Near(@DrawableRes override val drawableId: Int) : Map(drawableId) {
            public object Default : Near(R.drawable.spark_icons_near)
            public object Outline : Near(R.drawable.spark_icons_near_outline)
        }

        public object SimpleExpand : Map(R.drawable.spark_icons_expand_simple)

        public sealed class Train(@DrawableRes override val drawableId: Int) : Map(drawableId) {
            public object Default : Train(R.drawable.spark_icons_train)
            public object Outline : Train(R.drawable.spark_icons_train_outline)
        }

        public object Walker : Map(R.drawable.spark_icons_walker)
        public object Car : Map(R.drawable.spark_icons_car)
    }

    public sealed class Navs(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Arrow : Navs(R.drawable.spark_icons_notif_actif)
        public object Drawer : Navs(R.drawable.spark_icons_menu)
        public object Close : Navs(R.drawable.spark_icons_close)
    }

    public sealed class Notifications(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Active : Notifications(R.drawable.spark_icons_notif_actif)
        public object Default : Notifications(R.drawable.spark_icons_notif)
        public object Disable : Notifications(R.drawable.spark_icons_no_notif)
        public object Outline : Notifications(R.drawable.spark_icons_notif_outline)
    }

    public sealed class Options(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Booster : Options(R.drawable.spark_icons_booster)
        public sealed class Clock(@DrawableRes override val drawableId: Int) : Options(drawableId) {
            public object Arrow : Clock(R.drawable.spark_icons_clockarrow)
            public object Default : Clock(R.drawable.spark_icons_clock_filled)
            public object Outline : Clock(R.drawable.spark_icons_clock)
        }

        public object Credit : Options(R.drawable.spark_icons_credit)
        public object Flash : Options(R.drawable.spark_icons_flashlight)
        public object MoveUp : Options(R.drawable.spark_icons_moveup)
        public sealed class SpotLight(@DrawableRes override val drawableId: Int) : Options(drawableId) {
            public object Default : SpotLight(R.drawable.spark_icons_spotlight)
            public object Outline : SpotLight(R.drawable.spark_icons_spotlight_outline)
        }

        public sealed class Star(@DrawableRes override val drawableId: Int) : Options(drawableId) {
            public object Default : Star(R.drawable.spark_icons_star)
            public object Outline : Star(R.drawable.spark_icons_star_outline)
        }
    }

    public sealed class Others(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public sealed class Megaphone(@DrawableRes override val drawableId: Int) : Others(drawableId) {
            public object Default : Megaphone(R.drawable.spark_icons_demand_filled)
            public object Outline : Megaphone(R.drawable.spark_icons_demand)
        }

        public object SpeedoMeter : Others(R.drawable.spark_icons_speedometer)
        public object Dissatisfied : Others(R.drawable.spark_icons_dissatisfied)
        public object Euro : Others(R.drawable.spark_icons_euro)
        public object FlagOutline : Others(R.drawable.spark_icons_flag_outline)
        public object Satisfied : Others(R.drawable.spark_icons_satisfied)
        public object Package : Others(R.drawable.spark_icons_package)
        public object Refund : Others(R.drawable.spark_icons_refund)
    }

    public sealed class Paiement(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object GarantiePanne : Paiement(R.drawable.spark_icons_garantie_panne)
    }

    public sealed class Pro(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Actions : Pro(R.drawable.spark_icons_actions)
        public object Apparitions : Pro(R.drawable.spark_icons_apparitions)

        public sealed class Download(@DrawableRes override val drawableId: Int) : Pro(drawableId) {
            public object Default : Download(R.drawable.spark_icons_download)
            public object Outline : Download(R.drawable.spark_icons_download_outline)
        }

        public object MyPro : Pro(R.drawable.spark_icons_my_pro)
        public object SpaceShip : Pro(R.drawable.spark_icons_spaceship)
    }

    public sealed class Share(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object AttachFile : Share(R.drawable.spark_icons_attachment)
        public object Facebook : Share(R.drawable.spark_icons_facebook)
        public object Messenger : Share(R.drawable.spark_icons_messenger)
        public object Pinterest : Share(R.drawable.spark_icons_pinterest)
        public object Instagram : Share(R.drawable.spark_icons_instagram)
        public object Goto : Share(R.drawable.spark_icons_goto)
        public object Link : Share(R.drawable.spark_icons_link)
        public object ShareDefault : Share(R.drawable.spark_icons_share)
        public object ShareArrow : Share(R.drawable.spark_icons_share_arrow)
        public object Twitter : Share(R.drawable.spark_icons_twitter)
        public object WhatsApp : Share(R.drawable.spark_icons_whatsapp)
        public object Upload : Share(R.drawable.spark_icons_upload)
        public object Download : Share(R.drawable.spark_icons_share_download)
    }

    public sealed class Toggles(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Add : Toggles(R.drawable.spark_icons_add)

        public sealed class Check(@DrawableRes override val drawableId: Int) : Toggles(drawableId) {
            public object Default : Check(R.drawable.spark_icons_check)
            public object Outline : Check(R.drawable.spark_icons_check_outline)
            public object Simple : Toggles(R.drawable.spark_icons_check_simple)
            public object Double : Toggles(R.drawable.spark_icons_check_double)
        }
    }

    public sealed class User(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Pro : User(R.drawable.spark_icons_profile_pro2)
        public object Default : User(R.drawable.spark_icons_user)
        public object Outline : User(R.drawable.spark_icons_user_outline)
        public sealed class Group(@DrawableRes override val drawableId: Int) : User(drawableId) {
            public object Default : Group(R.drawable.spark_icons_user_group)
            public object Outline : Group(R.drawable.spark_icons_user_group_outline)
        }

        public object Verified : User(R.drawable.spark_icons_verified)
        public object Avatar : User(R.drawable.spark_icons_avatar_part)
        public object Store : User(R.drawable.spark_icons_profile_pro1_grey)
    }

    public sealed class Value(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId) {
        public object Minus : Value(R.drawable.spark_icons_minus_outline)

        public sealed class More(@DrawableRes override val drawableId: Int) : Value(drawableId) {
            public object Default : More(R.drawable.spark_icons_more)
            public object Outline : More(R.drawable.spark_icons_more_outline)
        }
    }

    public abstract class Custom(@DrawableRes override val drawableId: Int) : SparkIcon(drawableId)
}
