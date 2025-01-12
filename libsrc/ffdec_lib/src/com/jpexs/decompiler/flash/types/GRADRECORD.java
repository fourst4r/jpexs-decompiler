/*
 *  Copyright (C) 2010-2023 JPEXS, All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */
package com.jpexs.decompiler.flash.types;

import com.jpexs.decompiler.flash.types.annotations.Internal;
import com.jpexs.decompiler.flash.types.annotations.SWFType;
import java.io.Serializable;

/**
 *
 * @author JPEXS
 */
public class GRADRECORD implements Serializable {

    @SWFType(BasicType.UI8)
    public int ratio;

    @Internal
    public boolean inShape3;

    public RGB color;

    public float getRatioFloat() {
        return ((float) ratio) / 255.0f;
    }
    
    public MORPHGRADRECORD toMorphGradRecord() {
        MORPHGRADRECORD morphGradRecord = new MORPHGRADRECORD();
        morphGradRecord.startColor = new RGBA(color);
        morphGradRecord.endColor = new RGBA(color);
        morphGradRecord.startRatio = ratio;
        morphGradRecord.endRatio = ratio;
        return morphGradRecord;
    }
    
    public MORPHGRADRECORD toMorphGradRecord(GRADRECORD endGradRecord) {
        MORPHGRADRECORD morphGradRecord = new MORPHGRADRECORD();
        morphGradRecord.startColor = new RGBA(color);
        morphGradRecord.endColor = new RGBA(endGradRecord.color);
        morphGradRecord.startRatio = ratio;
        morphGradRecord.endRatio = endGradRecord.ratio;
        return morphGradRecord;
    }
}
