/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * (created at 2011-1-21)
 */
package org.lysu.shard.parser.ast.expression.primary;

import java.util.Map;

import org.lysu.shard.parser.visitor.SQLASTVisitor;

/**
 * <code>'?'</code>
 * 
 * @author <a href="mailto:shuo.qius@alibaba-inc.com">QIU Shuo</a>
 */
public class ParamMarker extends PrimaryExpression {
    private final int paramIndex;

    /**
     * @param paramIndex start from 1
     */
    public ParamMarker(int paramIndex) {
        this.paramIndex = paramIndex;
    }

    /**
     * @return start from 1
     */
    public int getParamIndex() {
        return paramIndex;
    }

    @Override
    public int hashCode() {
        return paramIndex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof ParamMarker) {
            ParamMarker that = (ParamMarker) obj;
            return this.paramIndex == that.paramIndex;
        }
        return false;
    }

    @Override
    public Object evaluationInternal(Map<? extends Object, ? extends Object> parameters) {
        return parameters.get(paramIndex);
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
