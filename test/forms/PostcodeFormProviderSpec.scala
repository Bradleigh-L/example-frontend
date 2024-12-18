package forms

import forms.behaviours.StringFieldBehaviours
import play.api.data.FormError

class PostcodeFormProviderSpec extends StringFieldBehaviours {

  val requiredKey = "postcode.error.required"
  val lengthKey = "postcode.error.length"
  val maxLength = 10

  val form = new PostcodeFormProvider()()

  ".value" - {

    val fieldName = "value"

    behave like fieldThatBindsValidData(
      form,
      fieldName,
      stringsWithMaxLength(maxLength)
    )

    behave like fieldWithMaxLength(
      form,
      fieldName,
      maxLength = maxLength,
      lengthError = FormError(fieldName, lengthKey, Seq(maxLength))
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
