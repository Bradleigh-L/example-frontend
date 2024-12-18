package forms

import forms.behaviours.BooleanFieldBehaviours
import play.api.data.FormError

class ReportSalesFormProviderSpec extends BooleanFieldBehaviours {

  val requiredKey = "reportSales.error.required"
  val invalidKey = "error.boolean"

  val form = new ReportSalesFormProvider()()

  ".value" - {

    val fieldName = "value"

    behave like booleanField(
      form,
      fieldName,
      invalidError = FormError(fieldName, invalidKey)
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
