/*
 * Copyright 2019 [name of copyright owner]
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

package kotlinguide.chapter03.solution

fun main() {
    // Solution 1
    for (value in 0..100 step 2) {
        println("value = $value")
    }

    // Solution 2
    for (value in 0..100) {
        if (value.isEven()) println("value = $value")
    }
}

fun Int.isEven() = this % 2 == 0