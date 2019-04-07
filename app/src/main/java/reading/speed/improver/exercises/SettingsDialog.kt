package reading.speed.improver.exercises

import android.content.DialogInterface
import android.widget.ArrayAdapter
import reading.speed.improver.R
import org.jetbrains.anko.*

class SettingsDialog(ui: AnkoContext<ExerciseScreen>) {

    lateinit var dialog: DialogInterface

    init {
        with(ui) {
            dialog = alert {
                val adapterCoefs = ArrayAdapter(
                        owner,
                        R.layout.support_simple_spinner_dropdown_item,
                        owner.textSizeCoefs.toList()
                )
                customView {
                    verticalLayout {

                        owner.settingsLayout = verticalLayout {
                            textView("Размер текста")
                            val coefs = spinner {
                                adapter = adapterCoefs
                                padding = dip(20)
                                setSelection(adapterCoefs.getPosition(owner.textSizeCoef))
                            }

                            okButton {
                                var selectedCoef = coefs.selectedItemPosition
                                owner.changeTextSize(adapterCoefs.getItem(selectedCoef))
                            }

                        }.lparams { padding = dip(10) }
                        padding = dip(10)

                    }
                }
            }.show()
        }
    }
}