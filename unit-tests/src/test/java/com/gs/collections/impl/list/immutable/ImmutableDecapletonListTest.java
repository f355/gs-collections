/*
 * Copyright 2011 Goldman Sachs.
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

package com.gs.collections.impl.list.immutable;

import com.gs.collections.api.list.ImmutableList;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.block.factory.Functions;
import com.gs.collections.impl.set.sorted.mutable.TreeSortedSet;
import com.gs.collections.impl.test.Verify;
import org.junit.Test;

public class ImmutableDecapletonListTest extends AbstractImmutableListTestCase
{
    @Override
    protected ImmutableList<Integer> classUnderTest()
    {
        return new ImmutableDecapletonList<Integer>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Override
    @Test
    public void toSortedSetBy()
    {
        MutableList<Integer> expected = TreeSortedSet.newSetWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").collect(Functions.getStringToInteger());
        MutableList<Integer> sortedList = this.classUnderTest().toSortedSetBy(Functions.getToString()).toList();
        Verify.assertListsEqual(expected, sortedList);
    }
}
