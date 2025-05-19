package ru.kpfu.itis.kmp.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.WixMadeforText_Medium
import exampleapp.composeapp.generated.resources.WixMadeforText_SemiBold
import exampleapp.composeapp.generated.resources.wix_made_for_text_regular
import org.jetbrains.compose.resources.Font

@Composable
fun getTypography(): Typography {
    val regular = FontFamily(
        Font(Res.font.wix_made_for_text_regular, FontWeight.Normal, FontStyle.Normal)
    )

    val medium = FontFamily(
        Font(Res.font.WixMadeforText_Medium, FontWeight.Normal, FontStyle.Normal)
    )

    val semiBold = FontFamily(
        Font(Res.font.WixMadeforText_SemiBold, FontWeight.Normal, FontStyle.Normal)
    )

    val baseline = Typography()
    return Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = semiBold),
        displayMedium = baseline.displayMedium.copy(fontFamily = semiBold),
        displaySmall = baseline.displaySmall.copy(fontFamily = semiBold),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = semiBold),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = semiBold),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = semiBold),
        titleLarge = baseline.titleLarge.copy(fontFamily = medium),
        titleMedium = baseline.titleMedium.copy(fontFamily = medium),
        titleSmall = baseline.titleSmall.copy(fontFamily = medium),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = regular),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = regular),
        bodySmall = baseline.bodySmall.copy(fontFamily = regular),
        labelLarge = baseline.labelLarge.copy(fontFamily = regular),
        labelMedium = baseline.labelMedium.copy(fontFamily = regular),
        labelSmall = baseline.labelSmall.copy(fontFamily = regular),
    )
}
