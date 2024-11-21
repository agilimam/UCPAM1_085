package com.example.ucp1pam


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun ucp1(
    modifier: Modifier = Modifier
) {


    Column (Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        SectionHeader()
        var nama by rememberSaveable { mutableStateOf("") }
        var noHp by remember { mutableStateOf("") }
        var selectGender by remember { mutableStateOf("") }

        var jenisKelamin = listOf("Laki Laki", "Perempuan")
        var namaUser by rememberSaveable { mutableStateOf("") }
        var alamatUser by remember { mutableStateOf("") }
        var noHpUser by remember { mutableStateOf("") }
        var selectGenderUser by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = "Yuk Lengkapi data dirimu",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
        )

        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        OutlinedTextField(
            value = noHp,
            onValueChange = {noHp = it},
            label = { Text("Nohp") },
            placeholder = { Text("Masukkan noHp") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number
            )
        )
        Text(
            text = "Jenis Kelamin",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
        )

        Row (){
            jenisKelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectGender == item,
                        onClick = {
                            selectGender = item
                        })
                    Text(item)
                }
            }


        }
        Button(
            onClick = {
                namaUser = nama
                selectGenderUser = selectGender
                noHpUser =noHp
            }
        ){ Text("Simpan") }

        Card {modifier.size(width = 100.dp, height = 200.dp)
            CardSection(judulParam = "Nomer HandPhone" , Isiparams = noHpUser)
            CardSection(judulParam = "Jenis Kelamin", Isiparams = selectGenderUser)



        }

    }

}

@Composable
fun SectionHeader(){
    Box(modifier = Modifier.fillMaxWidth()
        .background(Color.Blue)) {
        Row (
            modifier = Modifier.padding(15.dp)
        ) {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.umy),
                    contentDescription = "", Modifier.size(100.dp)
                )
                Icon(
                    Icons.Filled.Check, contentDescription = " ",
                    Modifier.padding(end = 10.dp).size(25.dp),
                    tint = Color.Red,
                )
            }
            Column (Modifier.padding(15.dp)){
                Text(text="Teknologi Informasi", color = Color.White
                )
                Spacer(Modifier.padding(3.dp))
                Text(text = "Universitas muhammadiyah yogyakarta", color =Color.White
                )
            }
        }

    }

}

@Composable
fun CardSection(judulParam : String, Isiparams :String) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$Isiparams", modifier = Modifier.weight(2f))
        }

    }
}