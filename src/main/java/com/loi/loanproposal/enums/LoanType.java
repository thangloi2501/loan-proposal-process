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
public enum LoanType {
    PERSONAL(0), HOME_EQUITY(1), SMALL_BUSINESS(2), CREDIT_CARD(3), OTHER(4);

    private final Integer databaseValue;

    public static LoanType fromDatabaseValue(Integer value) {
        return StreamEx.of(LoanType.values())
                       .findFirst(enumValue -> enumValue.databaseValue.equals(value))
                       .orElse(null);
    }

    public static Integer toDatabaseValue(LoanType enumValue) {
        return enumValue == null ? null : enumValue.databaseValue;
    }
}
