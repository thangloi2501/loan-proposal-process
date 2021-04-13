/*******************************************************************************
 * Copyright(c) FriarTuck Pte Ltd ("FriarTuck"). All Rights Reserved.
 *
 * This software is the confidential and proprietary information of FriarTuck.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with FriarTuck.
 *
 * FriarTuck MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-
 * INFRINGEMENT. FriarTuck SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 ******************************************************************************/
package com.loi.loanproposal.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import one.util.streamex.StreamEx;

/**
 * @author Loi Nguyen
 *
 */
@Getter
@AllArgsConstructor
public enum CustomerType {
    INDIVIDUAL(0), SME(1), CIB(2), OTHER(3);

    private final Integer databaseValue;

    public static CustomerType fromDatabaseValue(Integer value) {
        return StreamEx.of(CustomerType.values())
                       .findFirst(enumValue -> enumValue.databaseValue.equals(value))
                       .orElse(null);
    }

    public static Integer toDatabaseValue(CustomerType enumValue) {
        return enumValue == null ? null : enumValue.databaseValue;
    }
}
