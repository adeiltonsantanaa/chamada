export const isAuthenticated = () => {
    if (localStorage.getItem('accessToken') == null) {
        return false
    } else {return true}
}