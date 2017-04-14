package io.github.kobakei.kotlinexample.model.dao

import android.content.Context
import io.github.kobakei.kotlinexample.model.entity.OrmaDatabase

/**
 * OrmaDatabaseをラップするだけのクラス
 * kaptの制限のために必要
 *
 * Created by keisukekobayashi on 2017/04/14.
 */
class OrmaHolder(val context: Context) {

    val ormaDatabase: OrmaDatabase = OrmaDatabase.builder(context).build()

}