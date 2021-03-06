/**
 * Copyright 2018 Pankaj Kushwaha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pankaj.kotlin.recylerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.pankaj.kotlin.recyclerviewlibrary.RecyclerViewManager
import com.pankaj.kotlin.recyclerviewlibrary.interfaces.RecylerViewCallbackInterface
import kotlinx.android.synthetic.main.activity_list_activity.*
import kotlinx.android.synthetic.main.content_list_activity.*

class RecyclerViewActivity : AppCompatActivity(), RecylerViewCallbackInterface {
    var mLists = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_activity)
        setSupportActionBar(toolbar)

        mLists.add("Item 1")
        mLists.add("Item 2")
        mLists.add("Item 3")
        mLists.add("Item 4")
        mLists.add("Item 5")
        list.hasFixedSize()

        var obj = RecyclerViewManager()
        obj.init(this, this, mLists)
        obj.setCardPadding(15, 15, 15, 15);
        obj.setCardMargin(15, 15, 15, 15);
        obj.setCardCornerRadius(5.0f)
        obj.showListView(this, list,2)

        updateList.setOnClickListener {
            mLists.clear()
            mLists.add("Item 1")
            mLists.add("Item 2")
            mLists.add("Item 3")
            mLists.add("Item 4")
            mLists.add("Item 5")
            mLists.add("Item 6")
            obj.setCardBackgroundColor(android.R.color.darker_gray)
            obj.setCardCornerRadius(25.0f)
            obj.updateList(mLists)
            obj.setElevation(20.0f)
            obj.setTextColor(R.color.primary_material_light)
            obj.notifyUpdates();
        }
    }

    override fun itemClicked(pos: Int) {
        Toast.makeText(this, mLists.get(pos) + " clicked", Toast.LENGTH_SHORT)
                .show();
    }
}
