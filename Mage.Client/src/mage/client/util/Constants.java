/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.client.util;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public final class Constants {
	private Constants() {
		throw new AssertionError();
	}

	public static final int FRAME_MAX_HEIGHT = 367;
	public static final int FRAME_MAX_WIDTH = 256;
	public static final int ART_MAX_HEIGHT = 168;
	public static final int ART_MAX_WIDTH = 227;
	public static final int SYMBOL_MAX_HEIGHT = 28;
	public static final int SYMBOL_MAX_WIDTH = 28;
	public static final int SYMBOL_MAX_XOFFSET = 27;
	public static final int SYMBOL_MAX_YOFFSET = 15;
	public static final int SYMBOL_MAX_SPACE = 28;
	public static final int CONTENT_MAX_XOFFSET = 15;
	public static final int ART_MAX_YOFFSET = 37;
	public static final int NAME_MAX_YOFFSET = 27;
	public static final int TYPE_MAX_YOFFSET = 223;
	public static final int TEXT_MAX_YOFFSET = 232;
	public static final int TEXT_MAX_WIDTH = 227;
	public static final int TEXT_MAX_HEIGHT = 105;
	public static final int NAME_FONT_MAX_SIZE = 13;
	public static final int TEXT_FONT_MAX_SIZE = 11;
	public static final int PARAGRAPH_MAX_SPACING = 4;
	public static final int POWBOX_MAX_TOP = 336;
	public static final int POWBOX_MAX_LEFT = 202;
	public static final int DAMAGE_MAX_LEFT = 180;

	public static final double SCALE_FACTOR = 0.5;

	public static final int FRAME_HEIGHT = (int)(FRAME_MAX_HEIGHT * SCALE_FACTOR);
	public static final int FRAME_WIDTH = (int)(FRAME_MAX_WIDTH * SCALE_FACTOR);
	public static final int ART_HEIGHT = (int)(ART_MAX_HEIGHT * SCALE_FACTOR);
	public static final int ART_WIDTH = (int)(ART_MAX_WIDTH * SCALE_FACTOR);
	public static final int SYMBOL_HEIGHT = (int)(SYMBOL_MAX_HEIGHT * SCALE_FACTOR);
	public static final int SYMBOL_WIDTH = (int)(SYMBOL_MAX_WIDTH * SCALE_FACTOR);
	public static final int SYMBOL_XOFFSET = (int)(SYMBOL_MAX_XOFFSET * SCALE_FACTOR);
	public static final int SYMBOL_YOFFSET = (int)(SYMBOL_MAX_YOFFSET * SCALE_FACTOR);
	public static final int SYMBOL_SPACE = (int)(SYMBOL_MAX_SPACE * SCALE_FACTOR);
	public static final int CONTENT_XOFFSET = (int)(CONTENT_MAX_XOFFSET * SCALE_FACTOR);
	public static final int ART_YOFFSET = (int)(ART_MAX_YOFFSET * SCALE_FACTOR);
	public static final int NAME_YOFFSET = (int)(NAME_MAX_YOFFSET * SCALE_FACTOR);
	public static final int TYPE_YOFFSET = (int)(TYPE_MAX_YOFFSET * SCALE_FACTOR);
	public static final int TEXT_YOFFSET = (int)(TEXT_MAX_YOFFSET * SCALE_FACTOR);
	public static final int TEXT_WIDTH = (int)(TEXT_MAX_WIDTH * SCALE_FACTOR);
	public static final int TEXT_HEIGHT = (int)(TEXT_MAX_HEIGHT * SCALE_FACTOR);
	public static final int POWBOX_TOP = (int)(POWBOX_MAX_TOP * SCALE_FACTOR);
	public static final int POWBOX_LEFT = (int)(POWBOX_MAX_LEFT * SCALE_FACTOR);
	public static final int DAMAGE_LEFT = (int)(DAMAGE_MAX_LEFT * SCALE_FACTOR);
	public static final int NAME_FONT_SIZE = Math.max(9, (int)(NAME_FONT_MAX_SIZE * SCALE_FACTOR));
	public static final int TEXT_FONT_SIZE = Math.max(9, (int)(TEXT_FONT_MAX_SIZE * SCALE_FACTOR));
	public static final int PARAGRAPH_SPACING = (int)(PARAGRAPH_MAX_SPACING * SCALE_FACTOR);
	
}
