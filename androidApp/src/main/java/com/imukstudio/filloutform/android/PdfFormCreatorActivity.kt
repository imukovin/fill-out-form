package com.imukstudio.filloutform.android

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.tejpratapsingh.pdfcreator.activity.PDFCreatorActivity
import com.tejpratapsingh.pdfcreator.utils.PDFUtil.PDFUtilListener
import com.tejpratapsingh.pdfcreator.views.PDFBody
import com.tejpratapsingh.pdfcreator.views.PDFFooterView
import com.tejpratapsingh.pdfcreator.views.PDFHeaderView
import com.tejpratapsingh.pdfcreator.views.basic.PDFTextView
import com.tejpratapsingh.pdfcreator.views.basic.PDFVerticalView
import java.io.File


class PdfFormCreatorActivity : PDFCreatorActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        createPDF("test", object : PDFUtilListener {
            override fun pdfGenerationSuccess(savedPDFFile: File?) {
                Toast.makeText(this@PdfFormCreatorActivity, "PDF Created", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun pdfGenerationFailure(exception: Exception) {
                Toast.makeText(
                    this@PdfFormCreatorActivity,
                    "PDF NOT Created",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun getHeaderView(forPage: Int): PDFHeaderView {
        val headerView = PDFHeaderView(applicationContext)

        val verticalView = PDFVerticalView(applicationContext)
        val judgePdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.justice_of_the_peace_claim)} [ ----- ]")
        judgePdfTextView.view.gravity = Gravity.RIGHT
        judgePdfTextView.view.setPadding(0, 0, 0, 12)
        verticalView.addView(judgePdfTextView)
        val personPdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.claimant_claim)}: [ ----- ]")
        personPdfTextView.view.gravity = Gravity.RIGHT
        verticalView.addView(personPdfTextView)
        val addressPdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.address_claim)}: [ ----- ]")
        addressPdfTextView.view.gravity = Gravity.RIGHT
        addressPdfTextView.view.setPadding(0, 0, 0, 12)
        verticalView.addView(addressPdfTextView)
        val person1PdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.debtor_claim)}: [ ФИО, дата и место рождения ]")
        person1PdfTextView.view.gravity = Gravity.RIGHT
        verticalView.addView(person1PdfTextView)
        val address1PdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.place_of_residence_claim)}: [вписать нужное]")
        address1PdfTextView.view.gravity = Gravity.RIGHT
        verticalView.addView(address1PdfTextView)
        val workplacePdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.place_of_work_claim)}: [вписать нужное]")
        workplacePdfTextView.view.gravity = Gravity.RIGHT
        verticalView.addView(workplacePdfTextView)
        val idPdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.id_claim)} [СНИЛС, ИНН, серия и номер документа, удостоверяющего личность, ОГРНИП, серия и номер водительского удостоверения, серия и номер свидетельства о регистрации транспортного средства]")
        idPdfTextView.view.gravity = Gravity.RIGHT
        verticalView.addView(idPdfTextView)

        val formPdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.claim_title_claim)}")
        formPdfTextView.view.gravity = Gravity.CENTER
        formPdfTextView.view.typeface = Typeface.DEFAULT_BOLD
        formPdfTextView.view.setPadding(0, 30, 0, 0)
        verticalView.addView(formPdfTextView)
        val formDescriptionPdfTextView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.P)
            .setText("${resources.getText(R.string.claim_subtitle_claim)}")
        formDescriptionPdfTextView.view.gravity = Gravity.CENTER
        formDescriptionPdfTextView.view.typeface = Typeface.DEFAULT_BOLD
        verticalView.addView(formDescriptionPdfTextView)

        headerView.addView(verticalView)

        return headerView
    }

    override fun getBodyViews(): PDFBody {
        val pdfBody = PDFBody()
        val pdfCompanyNameView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.H3)
        pdfCompanyNameView.setText("Company Name")
        pdfBody.addView(pdfCompanyNameView)
        return pdfBody
    }

    override fun getFooterView(forPage: Int): PDFFooterView {
        return PDFFooterView(applicationContext)
    }

    override fun onNextClicked(savedPDFFile: File?) {
        Toast.makeText(applicationContext, "onNextClicked", Toast.LENGTH_SHORT).show()
    }

}
