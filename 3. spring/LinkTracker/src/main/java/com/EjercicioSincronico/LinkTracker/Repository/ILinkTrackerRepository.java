package com.EjercicioSincronico.LinkTracker.Repository;

import com.EjercicioSincronico.LinkTracker.Entities.Link;

public interface ILinkTrackerRepository {
    Link insertLink(Link l);
    Link getLinkbyId(int id);
    void updateStatus(int linkId, boolean newStatus);
    void updateMetrics(int linkId);
    int getMetricByLinkId(int linkId);

}
