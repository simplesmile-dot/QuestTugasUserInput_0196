package com.example.appuserinput.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.example.appuserinput.R
import com.example.appuserinput.ui.components.DatePickerField
import com.example.appuserinput.ui.components.ExperienceDropdown
import com.example.appuserinput.ui.components.FormTextField
import com.example.appuserinput.ui.components.SkillCheckbox
import com.example.appuserinput.ui.components.SkillRow
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@Composable
fun BiodataScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            containerColor = colorResource(R.color.screen_background),
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Image(
                painter = painterResource(R.drawable.img_header),
                contentDescription = stringResource(R.string.cd_header),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.header_height))
            )
        }
        // Box mengapung di atas Scaffold
        BiodataCard(modifier = Modifier.align(Alignment.BottomCenter))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiodataCard(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val cardShape = RoundedCornerShape(dimensionResource(R.dimen.card_corner))
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var birthDate by rememberSaveable { mutableStateOf("") }
    var experience by rememberSaveable { mutableStateOf("") }
    var showDatePicker by rememberSaveable { mutableStateOf(false) }
    val selectedSkills = remember { mutableStateListOf<Int>() }
    val skills = listOf(R.string.skill_android, R.string.skill_uiux, R.string.skill_web)
    val isFormValid = firstName.isNotBlank() && lastName.isNotBlank() &&
            email.isNotBlank() && birthDate.isNotBlank() &&
            experience.isNotBlank() && selectedSkills.isNotEmpty()

    Box(
        modifier = modifier
            .padding(
                start = dimensionResource(R.dimen.card_margin_horizontal),
                end = dimensionResource(R.dimen.card_margin_horizontal),
                bottom = dimensionResource(R.dimen.card_margin_bottom)
            )
            .fillMaxWidth()
            .shadow(dimensionResource(R.dimen.card_elevation), cardShape)
            .background(colorResource(R.color.white), cardShape)
            .padding(dimensionResource(R.dimen.card_padding))
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_medium))
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.form_title),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.purple_title),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(R.string.form_subtitle),
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.text_hint),
                    textAlign = TextAlign.Center
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_small))) {
                FormTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = stringResource(R.string.hint_first_name),
                    modifier = Modifier.weight(1f)
                )
                FormTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = stringResource(R.string.hint_last_name),
                    modifier = Modifier.weight(1f)
                )
            }

            FormTextField(
                value = email,
                onValueChange = { email = it },
                label = stringResource(R.string.hint_email),
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth()
            )
            // ISI FORM DITAMBAHKAN DI SINI (commit 23 s.d. 28)
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_small)))
        }
    }

    // DIALOG TANGGAL DITAMBAHKAN DI SINI (commit 29)
}