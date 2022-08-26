package com.wz.testtask.estore.purchase.comparator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.wz.testtask.estore.model.Purchase;

public class PurchaseDateComparator extends OrderByComparator<Purchase> {
    private static final Log logger = LogFactoryUtil.getLog(PurchaseDateComparator.class);
    private boolean _asc;
    
    public PurchaseDateComparator(boolean asc) {
        _asc = asc;
    }
    
    public int compare(Purchase p1, Purchase p2) {
        logger.info("Comparing " + p1 + " and " + p2);
        boolean before = p1.getPurchasedDate().before(p2.getPurchasedDate());
        if (_asc) {
            return before ? -1 : 1;
        } else {
            return before ? 1 : -1;
        }
        
    }
    
}
