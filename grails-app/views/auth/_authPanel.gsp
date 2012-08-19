<div class="auth panel">
	<g:if test="${session.usuario}">
		<g:render template="/auth/loggedInPanel" />
	</g:if>
	
	<g:else>
		<g:render template="/auth/loginForm" />
	</g:else>
</div>