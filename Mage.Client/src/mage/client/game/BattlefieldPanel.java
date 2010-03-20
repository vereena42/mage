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

/*
 * BattlefieldPanel.java
 *
 * Created on 10-Jan-2010, 10:43:14 PM
 */

package mage.client.game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import mage.client.cards.BigCard;
import mage.client.cards.Permanent;
import mage.view.PermanentView;
import static mage.client.util.Constants.*;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class BattlefieldPanel extends javax.swing.JPanel implements ComponentListener {

	private Map<UUID, Permanent> permanents = new HashMap<UUID, Permanent>();
	private UUID gameId;
	private BigCard bigCard;

    /** Creates new form BattlefieldPanel */
    public BattlefieldPanel() {
        initComponents();
    }

	public void init(UUID gameId, BigCard bigCard) {
		this.gameId = gameId;
		this.bigCard = bigCard;
	}

	public void update(Map<UUID, PermanentView> battlefield) {
		for (PermanentView permanent: battlefield.values()) {
			if (!permanents.containsKey(permanent.getId())) {
				addPermanent(permanent);
			}
			else {
				permanents.get(permanent.getId()).update(permanent);
			}
		}
		for (Iterator<Entry<UUID, Permanent>> i = permanents.entrySet().iterator(); i.hasNext();) {
			Entry<UUID, Permanent> entry = i.next();
			if (!battlefield.containsKey(entry.getKey())) {
				removePermanent(entry.getKey());
				i.remove();
			}
		}
		for (PermanentView permanent: battlefield.values()) {
			if (permanent.getAttachments() != null) {
				groupAttachments(permanent);
			}
		}
	}

	private void addPermanent(PermanentView permanent) {
		Permanent perm = new Permanent(permanent, bigCard, gameId);
		perm.addComponentListener(this);
		perm.setBounds(findEmptySpace(new Dimension(FRAME_WIDTH, FRAME_HEIGHT)));
		permanents.put(permanent.getId(), perm);
		this.add(perm);
		perm.update(permanent);
	}

	private void groupAttachments(PermanentView permanent) {
		Permanent perm = permanents.get(permanent.getId());
		perm.getLinks().clear();
		Rectangle r = perm.getBounds();
		for (UUID attachmentId: permanent.getAttachments()) {
			Permanent link = permanents.get(attachmentId);
			perm.getLinks().add(link);
			r.translate(20, 20);
			link.setBounds(r);
		}
	}

	private void removePermanent(UUID permanentId) {
        for (Component comp: this.getComponents()) {
        	if (comp instanceof Permanent) {
        		if (((Permanent)comp).getPermanentId().equals(permanentId)) {
					this.remove(comp);
        		}
        	}
        }
	}

	private Rectangle findEmptySpace(Dimension size) {
		int battlefieldWidth = this.getWidth();
		Rectangle r = new Rectangle(size);
		boolean intersects;
		while (true) {
			intersects = false;
			for (Permanent perm: permanents.values()) {
				Rectangle pr = perm.getBounds();
				if (r.intersects(pr)) {
					intersects = true;
					if (pr.x + pr.width + r.width > battlefieldWidth)
						r.setLocation(0, pr.y + pr.height + 1);
					else
						r.translate(pr.x + pr.width - r.x, 0);
					break;
				}
			}
			if (!intersects)
				break;
		}
		return r;
	}

	@Override
	public boolean isOptimizedDrawingEnabled () {
		return false;
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

	public void componentResized(ComponentEvent e) {
		resizeBattlefield();
	}

	public void componentMoved(ComponentEvent e) {
		resizeBattlefield();
	}

	public void componentShown(ComponentEvent e) {
		resizeBattlefield();
	}

	public void componentHidden(ComponentEvent e) {
		resizeBattlefield();
	}

	private void resizeBattlefield() {
        Dimension area = new Dimension(0, 0);
        Dimension size = getPreferredSize();

        for (Component comp: getComponents()) {
        	Rectangle r = comp.getBounds();
        	if (r.x + r.width > area.width) {
        		area.width = r.x + r.width;
        	}
        	if (r.y + r.height > area.height) {
        		area.height = r.y + r.height;
        	}
        }
        if (size.height != area.height || size.width != area.width) {
        	setPreferredSize(area);
        	revalidate();
        	repaint();
       }

	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
