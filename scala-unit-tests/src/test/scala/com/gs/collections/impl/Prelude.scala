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

package com.gs.collections.impl

import java.util.Comparator
import com.gs.collections.api.block.function.{Function, Function0, Function2, Function3}
import com.gs.collections.api.block.predicate.{Predicate2, Predicate}
import com.gs.collections.api.block.procedure.{ObjectIntProcedure, Procedure2, Procedure}

object Prelude
{
    // A "singleton" object to hold the implicit conversion methods
    /*
    * These three methods each take a closure and return an anonymous instance
    * of the corresponding GS Collections interface
    */
    implicit def closure2Procedure[T](closure: (T) => Unit) =
        new Procedure[T]
        {
            def value(each: T) = closure(each)
        }

    implicit def closure2Procedure2[T1, T2](closure: (T1, T2) => Unit) =
        new Procedure2[T1, T2]
        {
            def value(t1: T1, t2: T2) = closure(t1, t2)
        }

    implicit def closure2Function[T, V](closure: (T) => V) =
        new Function[T, V]
        {
            def valueOf(t: T) = closure(t)
        }

    implicit def closure2Function2[T1, T2, V](closure: (T1, T2) => V) =
        new Function2[T1, T2, V]
        {
            def value(t1: T1, t2: T2) = closure(t1, t2)
        }

    implicit def closure2Function3[T1, T2, T3, V](closure: (T1, T2, T3) => V) =
        new Function3[T1, T2, T3, V]
        {
            def value(t1: T1, t2: T2, t3: T3) = closure(t1, t2, t3)
        }

    implicit def closure2Predicate[T](closure: (T) => Boolean) =
        new Predicate[T]
        {
            def accept(each: T) = closure(each)
        }

    implicit def closure2Predicate2[T1, T2](closure: (T1, T2) => Boolean) =
        new Predicate2[T1, T2]
        {
            def accept(t1: T1, t2: T2) = closure(t1, t2)
        }

    implicit def closure2ObjectIntProcedure[T](closure: (T, Int) => Unit) =
        new ObjectIntProcedure[T]
        {
            def value(each: T, index: Int) = closure(each, index)
        }

    implicit def closure2Runnable(closure: () => Unit) =
        new Runnable
        {
            def run = closure()
        }

    implicit def closure2CodeBlock[T](closure: () => T) =
        new Function0[T]
        {
            def value = closure()
        }

    implicit def closure2Comparator[T](closure: (T, T) => Int) =
        new Comparator[T]
        {
            def compare(o1: T, o2: T) = closure(o1, o2)
        }
}
