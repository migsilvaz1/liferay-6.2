package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ec.gob.snap.vuv.model.Caso;

/**
 * The persistence interface for the caso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasoPersistenceImpl
 * @see CasoUtil
 * @generated
 */
public interface CasoPersistence extends BasePersistence<Caso> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CasoUtil} to access the caso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the caso in the entity cache if it is enabled.
    *
    * @param caso the caso
    */
    public void cacheResult(ec.gob.snap.vuv.model.Caso caso);

    /**
    * Caches the casos in the entity cache if it is enabled.
    *
    * @param casos the casos
    */
    public void cacheResult(java.util.List<ec.gob.snap.vuv.model.Caso> casos);

    /**
    * Creates a new caso with the primary key. Does not add the caso to the database.
    *
    * @param id_caso the primary key for the new caso
    * @return the new caso
    */
    public ec.gob.snap.vuv.model.Caso create(long id_caso);

    /**
    * Removes the caso with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_caso the primary key of the caso
    * @return the caso that was removed
    * @throws ec.gob.snap.vuv.NoSuchCasoException if a caso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Caso remove(long id_caso)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchCasoException;

    public ec.gob.snap.vuv.model.Caso updateImpl(
        ec.gob.snap.vuv.model.Caso caso)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the caso with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchCasoException} if it could not be found.
    *
    * @param id_caso the primary key of the caso
    * @return the caso
    * @throws ec.gob.snap.vuv.NoSuchCasoException if a caso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Caso findByPrimaryKey(long id_caso)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchCasoException;

    /**
    * Returns the caso with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_caso the primary key of the caso
    * @return the caso, or <code>null</code> if a caso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Caso fetchByPrimaryKey(long id_caso)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the casos.
    *
    * @return the casos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Caso> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the casos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of casos
    * @param end the upper bound of the range of casos (not inclusive)
    * @return the range of casos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Caso> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the casos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of casos
    * @param end the upper bound of the range of casos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of casos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Caso> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the casos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of casos.
    *
    * @return the number of casos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
