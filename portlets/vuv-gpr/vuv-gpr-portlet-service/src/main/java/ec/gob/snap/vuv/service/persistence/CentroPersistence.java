package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ec.gob.snap.vuv.model.Centro;

/**
 * The persistence interface for the centro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CentroPersistenceImpl
 * @see CentroUtil
 * @generated
 */
public interface CentroPersistence extends BasePersistence<Centro> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CentroUtil} to access the centro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the centro in the entity cache if it is enabled.
    *
    * @param centro the centro
    */
    public void cacheResult(ec.gob.snap.vuv.model.Centro centro);

    /**
    * Caches the centros in the entity cache if it is enabled.
    *
    * @param centros the centros
    */
    public void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Centro> centros);

    /**
    * Creates a new centro with the primary key. Does not add the centro to the database.
    *
    * @param id_centro the primary key for the new centro
    * @return the new centro
    */
    public ec.gob.snap.vuv.model.Centro create(long id_centro);

    /**
    * Removes the centro with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_centro the primary key of the centro
    * @return the centro that was removed
    * @throws ec.gob.snap.vuv.NoSuchCentroException if a centro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Centro remove(long id_centro)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchCentroException;

    public ec.gob.snap.vuv.model.Centro updateImpl(
        ec.gob.snap.vuv.model.Centro centro)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the centro with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchCentroException} if it could not be found.
    *
    * @param id_centro the primary key of the centro
    * @return the centro
    * @throws ec.gob.snap.vuv.NoSuchCentroException if a centro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Centro findByPrimaryKey(long id_centro)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchCentroException;

    /**
    * Returns the centro with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_centro the primary key of the centro
    * @return the centro, or <code>null</code> if a centro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Centro fetchByPrimaryKey(long id_centro)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the centros.
    *
    * @return the centros
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Centro> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the centros.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CentroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of centros
    * @param end the upper bound of the range of centros (not inclusive)
    * @return the range of centros
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Centro> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the centros.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CentroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of centros
    * @param end the upper bound of the range of centros (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of centros
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Centro> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the centros from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of centros.
    *
    * @return the number of centros
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
